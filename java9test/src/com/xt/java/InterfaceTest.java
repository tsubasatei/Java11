package com.xt.java;

/**
 * 面试题： 抽象类 和 接口 的异同？
 * 1. 二者的定义： a 声明的方式 abstract class、 interface
 *                b 内部的结构 (jdk 7, jdk 8, jdk 9)
 *
 * 2. 共同点： 不能实例化； 以多态的方式使用
 *
 * 3. 不同点： 单继承； 多实现
 */
interface MyInterface {

    // jdk 7 : 只能声明全局常量（public static final）和 抽象方法（public abstract）
    void method1();

    // jdk 8 : 声明静态方法 和 默认方法
    static void method2(){
        System.out.println("method2");
    }

    default void method3() {
        System.out.println("method3");
        method4();
    }

    // jdk 9 : 声明私有方法
    private void method4() {
        System.out.println("私有方法 method4");
    }
}

class MyInterfaceImpl implements MyInterface{

    @Override
    public void method1() {
        System.out.println("实现接口的抽象方法 method1");
    }
}
public class InterfaceTest {

    public static void main(String[] args) {
        MyInterfaceImpl my = new MyInterfaceImpl();

        my.method1();
        my.method3();
        MyInterface.method2();
    }
}
