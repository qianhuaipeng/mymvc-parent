package com.alan.web.bind.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * author: alan.peng
 * description:
 * date: create in 10:50 2018/8/10
 * modified By：
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {

    String[] value() default "";

    RequestMethod[] method() default {};
}
