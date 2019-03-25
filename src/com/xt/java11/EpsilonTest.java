package com.xt.java11;

import java.util.LinkedList;
import java.util.List;

/**
 * @author xt
 * @create 2019/3/25 11:18
 * @Desc
 */
class Garbage{
    private double d1 = 1;
    private double d2 = 2;

    // 这个方法是 GC 在消除本对象是，会调用一次
    @Override
    public void finalize(){
        System.out.println(this + " collecting");
    }
}
public class EpsilonTest {

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
