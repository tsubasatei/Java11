package com.xt.java;

/**
 * String、StringBuffer、 StringBuilder 的异同
 *
 * String: jdk8及之前，底层使用 char[] 存储； jdk9，底层使用 byte[] (encoding flag)
 * StringBuffer: jdk8及之前，底层使用 char[] 存储； jdk9，底层使用 byte[]
 * StringBuilder: jdk8及之前，底层使用 char[] 存储； jdk9，底层使用 byte[]
 *
 * String: 不可变的字符序列
 * StringBuffer: 可变的字符序列； 线程安全的，效率低
 * StringBuilder: 可变的字符序列； 线程不安全的，效率高(jdk 5.0)
 */
public class StringTest {
}
