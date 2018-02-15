package com.delicacy.orange.mybatis.v1;

import com.delicacy.orange.mybatis.v1.impl.DefaultSqlSession;

/**
 * 启动类
 *
 * @author zyt
 * @create 2018-02-04 14:34
 **/
public class BootStrap {

    public static void main(String[] args) {
        SqlSession sqlsession = new DefaultSqlSession();
        Mapper mapper = sqlsession.getMapper(Mapper.class);
        Entity entity = mapper.selectOne(1001L);
        System.out.println(entity.getName());
    }
}