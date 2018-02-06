package com.delicacy.orange.mybatis.v1;

import java.lang.reflect.Proxy;

/**
 * sql session 实现类
 *
 * @author zyt
 * @create 2018-02-04 14:45
 **/
public class DefaultSqlSession implements SqlSession {

    private Executor excutor = new SimpleExcutor();


    @Override
    public <T> T selectOne(String statement, Object parameter) {
        return excutor.query(statement, parameter);
    }

    @Override
    public <T> T getMapper(Class<T> clas) {
        MapperProxy mapperProxy = new MapperProxy(this);
        return (T) Proxy.newProxyInstance(clas.getClassLoader(), new Class[]{clas}, mapperProxy);
    }
}