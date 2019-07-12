package com.ss.junit.poi;

import com.ss.junit.poi.annno.PoiExport;
import com.ss.junit.poi.dto.Person;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Test
 *
 * @author shisong
 * @date 2019/7/12
 */
public class Test {

    public static void main(String[] args) {
        print(Person.class);
    }

    public static void print(Class c){
        System.out.println(c.getName());
        Map<String,String> map = new HashMap<>();
        Map<Integer,String> map2 = new HashMap<>();
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            boolean annotationPresent = field.isAnnotationPresent(PoiExport.class);
            if(annotationPresent){
                PoiExport annotation = field.getAnnotation(PoiExport.class);
                map.put(field.getName(),annotation.column());
                map2.put(annotation.order(),field.getName());
            }
        }
        System.out.println(map2);
        System.out.println(map);
    }

}
