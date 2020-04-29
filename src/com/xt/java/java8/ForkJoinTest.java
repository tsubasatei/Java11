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
        //  range，需要传入开始节点和结束节点两个参数，返回的是一个有序的LongStream。
        //  包含开始节点和结束节点两个参数之间所有的参数，间隔为1.
        // rangeClosed的功能和range类似。差别就是rangeClosed包含最后的结束节点，range不包含
        OptionalLong reduce = LongStream.rangeClosed(0, 10000000l)
                .parallel()
                .reduce(Long::sum);
        Instant end = Instant.now();
        System.out.println(reduce.getAsLong());
        System.out.println(Duration.between(start, end).toMillis());
    }
}
