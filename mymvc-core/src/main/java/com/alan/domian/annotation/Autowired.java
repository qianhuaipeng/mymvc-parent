package com.alan.domian.annotation;

import java.lang.annotation.*;

/**
 * author: alan.peng
 * description:
 * date: create in 14:11 2018/8/8
 * modified By：
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Autowired {

    boolean required() default true;
}
