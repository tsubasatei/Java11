package com.xt.java.java11;

import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/**
 * 集合中一些增强的API
 */
public class APITest {


    @Test
    public void test3() {
        LocalDate localDate = LocalDate.of(2019, 3, 24);
        System.out.println(localDate);  // 2019-03-24

        // 在添加重复元素时，不是无法添加，而是抛出异常
//        Set<Integer> set = Set.of(100, 50, 30, 30, 50);
        Set<Integer> set = Set.of(100, 50, 30);
        System.out.println(set);
        System.out.println(set.getClass());

        Stream<Integer> stream = Stream.of(100, 20, 30, 50);
        System.out.println(stream);

    }

    @Test
    public void test2(){
        List<String> list = Arrays.asList("aa", "bb", "CC", "DD");
        System.out.println(list);

        list.add("ee"); // 是一个不可以添加元素的集合
        System.out.println(list);
    }

    @Test
    public void test1(){
        // 集合的创建可以使用更简单的方式
        List<String> list = List.of("aa", "bb", "CC", "DD");
        System.out.println(list);

        list.add("ee"); // 不可以添加元素
        System.out.println(list);
    }
}
