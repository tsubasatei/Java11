package com.xt.java11;

import org.junit.Test;

import java.util.stream.Stream;

/**
 * 流的处理
 * 1）创建流
 * 2）中间操作
 * 3）终止操作
 */
public class StreamTest {

    @Test
    public void test3() {
        // 流的迭代，创建流
        Stream<Integer> stream = Stream.iterate(1, t -> 2 * t + 1);
        stream.limit(10).forEach(System.out::println);
        System.out.println("----------");
        // 有限的迭代，终止条件，t运算的结果小于1000
        Stream<Integer> stream1 = Stream.iterate(1, t -> t < 1000, t -> 2 * t + 1);
        stream1.forEach(System.out::println);
    }

    @Test
    public void test2() {
        Stream<Integer> stream = Stream.of(100, 30, 57, 68, 20);
        // 新方法 takeWhile, dropWhile
        // 从流中一直获取判定器为真的元素，一旦遇到元素为假，就终止处理
        Stream<Integer> stream1 = stream.takeWhile(t -> t % 2 == 0);
        stream1.forEach(System.out::println);  // 100 30

        System.out.println("--------------");
        stream = Stream.of(100, 30, 57, 68, 20);
        Stream<Integer> stream2 = stream.dropWhile(t -> t % 2 == 0);
        stream2.forEach(System.out::println); // 57 68 20
    }

    @Test
    public void test1() {
        Stream<Integer> stream = Stream.of(100, 30, 57, 68);
//        stream.forEach(t -> System.out.println(t));
        stream.forEach(System.out::println);

        System.out.println("------------");

        Stream<Object> stream1 = Stream.of(); // 流中没有数据
        stream1.forEach(System.out::println);

        // 传入 null 会被解析为一个数组对象，会进一步访问它的长度信息
//        Stream<Object> stream2 = Stream.of(null);
//        stream1.forEach(System.out::println);

        System.out.println("------------");

        // 可以传入一个null来创建流对象
        Stream<Object> stream3 = Stream.ofNullable(null);
        stream3.forEach(System.out::println);
    }
}
