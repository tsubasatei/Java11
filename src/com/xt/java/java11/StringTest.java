package com.xt.java.java11;

import org.junit.Test;

import java.io.FileInputStream;

public class StringTest {

    @Test
    public void test2() throws Exception {
        FileInputStream fis = new FileInputStream("src/com/xt/java/java11/StringTest.java");
        byte[] buffer = new byte[fis.available()];
        fis.read(buffer);
        fis.close();
        String string = new String(buffer);
        string.lines().forEach(System.out::println);
    }

    @Test
    public void test1(){
        String string = "Java";
        // 重复追加
        String s = string.repeat(5);
        System.out.println(s);
    }
    @Test
    public void test(){
        String string = " \t  \r\n ";
        System.out.println(string.isBlank()); // true  判断字符串中的字符是否都是空白
        System.out.println(string.isEmpty()); // false

        System.out.println("------------");

        String string1 = " \t  \r\n abc \t　";
        // 去除字符串首尾的空白，包括英文和其他所有语言中的空白字符
        String s = string1.strip();
        System.out.println(s);      // abc
        System.out.println(s.length()); // 3

        // 去除字符串首尾的空白，只能去除码值小于等于32的空白字符
        String s1 = string1.trim();
        System.out.println(s1);   // abc_ _ _ 	　
        System.out.println(s1.length()); //6

        System.out.println("------------");
        // 去除字符串首部的空白
        String s2 = string1.stripLeading();
        System.out.println(s2);
        System.out.println(s2.length()); // 6

        // 去除字符串尾部的空白
        String s3 = string1.stripTrailing();
        System.out.println(s3);
        System.out.println(s3.length()); // 10
    }
}
