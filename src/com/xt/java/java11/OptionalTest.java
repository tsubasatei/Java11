package com.xt.java.java11;

import org.junit.Test;

import java.util.Optional;

/**
 * @author xt
 * @create 2019/3/25 8:44
 * @Desc
 */
public class OptionalTest {
    @Test
    public void test(){
        // of 方法如果传入的参数是 null，会抛出空指针异常
//        Optional<String> optional = Optional.of(null);

        // ofNullable 可以兼容空指针，但是实际传入 null 后要小心
        Optional<Object> optional1 = Optional.ofNullable(null);
        // 如果内部引用为空，则返回参数中的引用，否则返回内部引用
        Object o = optional1.orElse("abc");
        System.out.println(o);

        // 传入null，抛异常：java.util.NoSuchElementException: No value present
        Object o1 = optional1.orElseThrow();
    }
}
