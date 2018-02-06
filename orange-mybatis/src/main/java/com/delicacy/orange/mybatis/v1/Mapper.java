package com.delicacy.orange.mybatis.v1;

public interface Mapper {
    <T> T selectOne(Long id);
}
