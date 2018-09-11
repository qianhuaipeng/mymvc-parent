package com.alan.web.bind.annotation;

import java.lang.annotation.*;

/**
 * author: alan.peng
 * description:
 * date: create in 15:26 2018/9/10
 * modified By：
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ModelAttribute {

    String value() default "";
}
