package com.xt.java.java8;

// 测试接口的默认方法和静态方法
public class DefaultInterfaceTest {
    public static void main(String[] args) {
        SubClass sc = new SubClass();

        System.out.println(sc.getName());

        MyInterface.show();
    }
}
