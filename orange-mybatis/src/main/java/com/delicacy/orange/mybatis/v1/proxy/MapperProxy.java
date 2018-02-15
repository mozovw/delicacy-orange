package com.delicacy.orange.mybatis.v1.proxy;

import com.delicacy.orange.mybatis.v1.MapperXml;
import com.delicacy.orange.mybatis.v1.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MapperProxy implements InvocationHandler {

    private SqlSession sqlSession;

    public MapperProxy(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //mapper里面的方法和mapperxml里面的类名和方法名称进行比较
        if (method.getDeclaringClass().getName().equals(MapperXml.nameSpace)) {
            String sql = MapperXml.getMethodSql(method.getName());
            //mothod.invoke(this,args);
            //mybatis使用的是反射
            return sqlSession.selectOne(sql, String.valueOf(args[0]));
        }
        return null;
    }

}  