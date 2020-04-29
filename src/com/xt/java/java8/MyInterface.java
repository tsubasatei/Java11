package com.xt.java.java8;

public interface MyInterface {

    default String getName(){
        return "哈哈哈";
    }

    static void show() {
        System.out.println("接口中的静态方法");
    }
}
