package com.alex.designpattern.practice.customizeannotation.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 单例模式注解
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface SingleTon {
}
