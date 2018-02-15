package com.delicacy.orange.mybatis.v1;

import java.util.List;

public interface Executor {
     String driver = "com.mysql.jdbc.Driver";
     String url = "jdbc:mysql://127.0.0.1:3306/test";
     String username = "root";
     String password = "123456";

     <T> T queryOne(String sql, Object parameter);

     <T> List<T> queryList(String sql, Object parameter);
}
