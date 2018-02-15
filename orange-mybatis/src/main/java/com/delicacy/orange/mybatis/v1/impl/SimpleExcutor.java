package com.delicacy.orange.mybatis.v1.impl;

import com.delicacy.orange.mybatis.v1.Entity;
import com.delicacy.orange.mybatis.v1.Executor;

import java.sql.*;
import java.util.List;

public class SimpleExcutor implements Executor {
    //可以考虑使用数据库线程池
    static ThreadLocal<Connection> local = new ThreadLocal<>();

    @Override
    public <T> T queryOne(String sql, Object parameter) {
        openConnection();
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

    @Override
    public <T> List<T> queryList(String sql, Object parameter) {
        openConnection();
        sql = sql.replace("?", String.valueOf(parameter));
        try {
            PreparedStatement pre = local.get().prepareStatement(sql);
            ResultSet set = pre.executeQuery();
            Entity u = new Entity();
            while (set.next()) {
                String string = set.getString(2);
                u.setName(string);
            }
            return (List<T>) u;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            closeConnection();
        }
        return null;
    }

    private void openConnection() {

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