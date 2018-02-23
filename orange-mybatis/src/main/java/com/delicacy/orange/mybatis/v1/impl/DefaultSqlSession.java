package com.delicacy.orange.mybatis.v1.impl;

import com.delicacy.orange.mybatis.v1.Executor;
import com.delicacy.orange.mybatis.v1.proxy.MapperProxy;
import com.delicacy.orange.mybatis.v1.SqlSession;

import java.lang.reflect.Proxy;
import java.util.List;

/**
 * sql session 实现类
 *
 * @author zyt
 * @create 2018-02-04 14:45
 **/
public class DefaultSqlSession implements SqlSession {

    //
    private Executor excutor = new SimpleExcutor();

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        return excutor.queryOne(statement, parameter);
    }

    @Override
    public <T> T getMapper(Class<T> clas) {
        //代理类
        MapperProxy mapperProxy = new MapperProxy(this);
        //mapper class
        return (T) Proxy.newProxyInstance(clas.getClassLoader(), new Class[]{clas}, mapperProxy);
    }
}