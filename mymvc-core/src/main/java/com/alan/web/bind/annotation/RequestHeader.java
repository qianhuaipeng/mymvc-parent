package com.alan.web.bind.annotation;

import java.lang.annotation.*;

/**
 * author: alan.peng
 * description:
 * date: create in 16:24 2018/9/10
 * modified By：
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestHeader {

    String value() default "";

    boolean required() default true;

    String defaultValue() default ValueConstants.DEFAULT_NONE;
}
