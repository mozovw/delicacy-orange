package com.delicacy.orange.mybatis.v1;

import java.sql.*;

public class SimpleExcutor implements Executor {
    //可以考虑使用数据库线程池
    static ThreadLocal<Connection> local = new ThreadLocal<>();

    @Override
    public <T> T query(String sql, Object parameter) {
        openConnection();
        PreparedStatement preparedStatement = null;
        sql = sql.replace("?", String.valueOf(parameter));
        try {
            PreparedStatement pre = local.get().prepareStatement(sql);
            ResultSet set = pre.executeQuery();
            Entity u = new Entity();
            while (set.next()) {
                String string = set.getString(2);
               u.setName(string);
            }
            return (T) u;
        } catch (SQLException e) {
            // TODO Auto-generated catch block  
            e.printStackTrace();
        }finally {
            closeConnection();
        }
        return null;
    }

    private void openConnection() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/test";
        String username = "root";
        String password = "123456";
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password);
            local.set(connection);
        } catch (Exception e) {
            // TODO Auto-generated catch block  
            e.printStackTrace();
        }
    }

    private void closeConnection() {
        Connection connection = null;
        try {
            connection = local.get();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }



}  