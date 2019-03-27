package com.xt.java;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * try 增强: 不用显式的处理资源的关闭
 * java 8中：要求资源对象的实例化，必须放在 try 的一对()内完成
 * java 9中：可以在 try()中调用已经实例化的资源对象
 */
public class TryTest {

    public void test () {
        try(InputStreamReader reader = new InputStreamReader(System.in)) {
            reader.read();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 不可以在 jdk8 及以前的版本中使用
    public void test1 () {
        InputStreamReader reader = new InputStreamReader(System.in);
        OutputStreamWriter writer = new OutputStreamWriter(System.out);
        try(reader; writer) {  // 引用多个，用 ; 分隔
            reader.read();

            // 此时的 reader 是 final 的，不可再被赋值
            //reader = null;
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 不可以在 jdk11 及以前的版本中使用
    public void test2 () {

        try(var reader = new InputStreamReader(System.in);
            var writer = new OutputStreamWriter(System.out)) {
            reader.read();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
