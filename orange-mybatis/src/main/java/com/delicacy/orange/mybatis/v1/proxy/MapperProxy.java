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
            Method[] methods = sqlSession.getClass().getMethods();
            for (Method m : methods) {
                //最好根据方法返回类型判断session用哪个方法
                //这里根据方法名称判断
                if(m.getName().equals(method.getName())){
                    Object invoke = m.invoke(sqlSession,sql, String.valueOf(args[0]));
                    return invoke;
                }
            }
        }
        return null;
    }

}  