package com.alan.validation;

import java.lang.annotation.Annotation;

/**
 * author: alan.peng
 * description:
 * date: create in 17:21 2018/9/10
 * modified By：
 */
public interface ConstraintValidator<A extends Annotation, T> {

    void initialize(A constraintAnnotation);

    boolean isValid(T value);

}
