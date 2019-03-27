package com.xt.java;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * <>钻石操作符
 */
public class DiamondOperatorTest {

    @Test
    public void test () {
        diamondOperator();
    }

    public void diamondOperator() {
        // 创建一个继承于 HashSet 的匿名子类的对象
        Set<String> set = new HashSet<>(){}; // 编译通过

        set.add("MM");
        set.add("JJ");
        set.add("GG");
        set.add("DD");

        set.forEach(System.out::println);
    }
}
