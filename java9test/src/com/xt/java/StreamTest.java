package com.xt.java;

import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

/**
 * jdk 9 中针对 Stream 新添加了4个方法
 */
public class StreamTest {
    @Test
    public void test () {
        // 1. takeWhile()
        List<Integer> list = List.of(45, 56, 33, 77, 44, 98, 76, 78, 33);
        list.stream()
                .takeWhile(x -> x < 70)
                .forEach(System.out::println); // 45, 56, 33

        System.out.println("-----------");

        // 2. dropWhile() : 与 takeWhile() 正好相反
        list.stream()
                .dropWhile(x -> x < 70)
                .forEach(System.out::println); // 77, 44, 98, 76, 78, 33

        System.out.println("-----------");
        // 3. ofNullable(T t): t可以为 null
        Stream<Integer> stream = Stream.of(1, 2, 3, null);
        stream.forEach(System.out::println); // 1, 2, 3, null

        System.out.println("-----------");

        // 如果只有单个元素，此元素不能为 null。否则报 NullPointerException
        /*Stream<Object> stream1 = Stream.of(null);
        stream1.forEach(System.out::println);*/

        Stream<Object> stream2 = Stream.ofNullable(null);
        System.out.println(stream2.count()); // 0
        Stream<Object> stream3 = Stream.ofNullable(1);
        System.out.println(stream3.count()); // 1

        System.out.println("------------");

        // 4 iterator() 重载的方法
        /**
         * Stream 的实例化：
         * 1. 通过集合的 stream()
         * 2. 通过数组工具类：Arrays
         * 3. Stream 中静态方法 of()
         * 4. iterator() 迭代
         */
        Stream.iterate(0, x -> x < 10, x -> 2*x+1)
                .forEach(System.out::println);

        System.out.println("---------------");

        Stream.iterate(0, x -> 2*x+1).limit(10)
                .forEach(System.out::println);
    }
}
