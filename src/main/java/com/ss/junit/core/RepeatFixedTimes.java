package com.ss.junit.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * RepeatFixed
 *
 * @author shisong
 * @date 2019/7/11
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RepeatFixedTimes {

    int value() default 1;

    boolean printDetail() default false;
}
