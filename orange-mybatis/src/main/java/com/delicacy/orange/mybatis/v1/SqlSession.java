package com.delicacy.orange.mybatis.v1;

/**
 * sql session interface
 *
 * @author zyt
 * @create 2018-02-04 14:33
 **/
public interface SqlSession {

    public <T> T selectOne(String statement,Object parameter);

    public <T> T getMapper(Class<T> clas);
}