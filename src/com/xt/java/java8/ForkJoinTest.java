package com.xt.java.java8;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.OptionalLong;
import java.util.stream.LongStream;

/**
 * Java 8 并行流
 * parallel()    并行
 * sequential()   串行
 *
 */
public class ForkJoinTest {
    @Test
    public void test () {
        // 获取当前时间
        Instant start = Instant.now();
        OptionalLong reduce = LongStream.rangeClosed(0, 10000000l)
                .parallel()
                .reduce(Long::sum);
        Instant end = Instant.now();
        System.out.println(reduce.getAsLong());
        System.out.println(Duration.between(start, end).toMillis());
    }
}
