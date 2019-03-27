package com.xt.java8;

/**
 * @author xt
 * @create 2019/3/27 8:43
 * @Desc
 */
public interface MyInterface {

    default String getName(){
        return "哈哈哈";
    }

    static void show() {
        System.out.println("接口中的静态方法");
    }
}
