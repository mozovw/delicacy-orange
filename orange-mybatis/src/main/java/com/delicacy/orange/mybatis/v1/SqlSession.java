package com.delicacy.orange.mybatis.v1;

import java.util.List;

/**
 * sql session interface
 *
 * @author zyt
 * @create 2018-02-04 14:33
 **/
public interface SqlSession {

     <T> T selectOne(String statement,Object parameter);

     <T> T getMapper(Class<T> clas);
}