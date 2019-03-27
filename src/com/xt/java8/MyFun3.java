package com.xt.java8;

/**
 * @author xt
 * @create 2019/3/25 19:25
 * @Desc
 */
@FunctionalInterface
public interface MyFun3<R, T> {

    R getValue(T t1, T t2);
}
