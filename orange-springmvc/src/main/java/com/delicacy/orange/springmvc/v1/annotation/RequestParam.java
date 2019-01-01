package com.delicacy.orange.springmvc.v1.annotation;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented

public @interface RequestParam {

    String value();
}