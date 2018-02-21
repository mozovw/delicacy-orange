package com.delicacy.orange.mybatis.v1;

import java.util.List;

public interface Mapper {
    <T> T selectOne(Long id);
}
