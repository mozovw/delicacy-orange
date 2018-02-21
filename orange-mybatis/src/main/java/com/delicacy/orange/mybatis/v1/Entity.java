package com.delicacy.orange.mybatis.v1;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 实体
 *
 * @author zyt
 * @create 2018-02-04 14:17
 **/
@Data
@Accessors(chain = true)
public class Entity {
    private Long id;
    private String name;
}