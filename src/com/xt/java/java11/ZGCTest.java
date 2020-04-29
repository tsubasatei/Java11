package com.xt.java.java11;

import java.util.LinkedList;
import java.util.List;

public class ZGCTest {

    // jdk14 支持 -XX:+UnlockExperimentalVMOptions XX:+UseZGC
    // Windos环境下不支持-XX:+UseZGC not supported，可在Linux下使用
    public static void main(String[] args) {
        List<Garbage> list = new LinkedList<>();
        boolean flag = true;
        int count = 0;
        while (flag) {
            list.add(new Garbage());
            if(count ++ == 500) {
                list.clear();
            }
        }
    }

}
