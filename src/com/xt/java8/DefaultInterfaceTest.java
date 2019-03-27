package com.xt.java8;

/**
 * @author xt
 * @create 2019/3/27 8:44
 * @Desc
 */
public class DefaultInterfaceTest {
    public static void main(String[] args) {
        SubClass sc = new SubClass();

        System.out.println(sc.getName());

        MyInterface.show();
    }
}
