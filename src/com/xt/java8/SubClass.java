package com.xt.java8;

/**
 * 类优先
 * 接口冲突，自己实现
 */
public class SubClass /*extends MyClass */implements MyInterface, MyFun4{
    @Override
    public String getName() {
        return MyFun4.super.getName();
    }
}
