package com.xt.java.java8;

// 函数接口
@FunctionalInterface
public interface MyFun3<R, T> {

    R getValue(T t1, T t2);
}
