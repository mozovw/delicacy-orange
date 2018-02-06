package com.delicacy.orange.mybatis.v1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MapperProxy implements InvocationHandler {

    private SqlSession sqlSession;

    public MapperProxy(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // TODO Auto-generated method stub  
        if (method.getDeclaringClass().getName().equals(MapperXml.nameSpace)) {
            String sql = MapperXml.methodSqlMapping.get(method.getName());
            //mothod.invoke(this,args);
            //mybatis使用的是反射
            return sqlSession.selectOne(sql, String.valueOf(args[0]));
        }
        return null;
    }

}  