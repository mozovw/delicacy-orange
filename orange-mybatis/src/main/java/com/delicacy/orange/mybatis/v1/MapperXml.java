package com.delicacy.orange.mybatis.v1;

import java.util.HashMap;
import java.util.Map;

public class MapperXml {
    public static final String nameSpace ="com.delicacy.orange.mybatis.arraylist.Mapper";
    public static final Map<String, String> methodSqlMapping =  new HashMap<>();
    static {
        methodSqlMapping.put("selectOne","select * from t_emp where id = ?");
    }
    public static String getMethodSql(String statement){
       return methodSqlMapping.get(statement);
    }
}

