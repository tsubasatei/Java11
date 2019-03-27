package com.xt.java;

import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Optional 类中提供了转换为 stream 的方法：stream()
 */
public class OptionalTest {
    @Test
    public void test () {
        List<String> list = List.of("aa", "bb", "cc");

        Optional<List<String>> op = Optional.ofNullable(list);
//        System.out.println(op.stream().count());  // 1
        op.stream().forEach(System.out::println);  // [aa, bb, cc]

        Stream<String> stream = op.stream().flatMap(x -> x.stream());
//        System.out.println(stream.count()); // 3
        stream.forEach(System.out::println);  // aa, bb, cc
    }
}
