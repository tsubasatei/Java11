package com.xt.java.java8;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * 重复注解与类型注解
 */

public class AnnotionTest {

    // checker framework 框架
    private /*@NonNull*/ Object obj;

    @Test
    public void test () throws NoSuchMethodException {
        Class<AnnotionTest> clazz = AnnotionTest.class;
        Method m = clazz.getMethod("show", String.class);

        MyAnnotation[] mas = m.getAnnotationsByType(MyAnnotation.class);
        for (MyAnnotation ma : mas) {
            System.out.println(ma.value());
        }
    }

    @MyAnnotation("hello")
    @MyAnnotation("world")
    public void show(@MyAnnotation("abe") String str) {

    }
}
