package com.ss.junit.poi.annno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * PoiExport
 *
 * @author shisong
 * @date 2019/7/12
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface PoiExport {

    String column();

    int order();
}
