package com.delicacy.orange.mybatis.v1;

public interface Executor {

    public <T> T query(String sql, Object parameter);
}
