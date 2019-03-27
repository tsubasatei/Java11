package com.xt.java.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Java8 内置的四大核心函数式接口
 *
 * Consumer<T> : 消费型接口
 *      void accept(T t);
 *
 * Supplier<T> : 供给型接口
 *      T get();
 *
 * Function<T, R> : 函数型接口
 *      R apply(T t);
 *
 * Predicate<T> : 断言型接口
 *      boolean test(T t);
 *
 */
public class LambdaTest2 {

    // Predicate<T> 断言型接口
    @Test
    public void test4() {
        List<String> list = List.of("Java", "Python", "C#", "Scala", "Go");
        List<String> strings = filterList(list, str -> str.length() > 3);
        System.out.println(strings);
    }
    // 将满足条件的字符串，放入集合中
    public List<String> filterList(List<String> list, Predicate<String> pre){
        List<String> strings = new ArrayList<>();
        for (String str:list) {
            if(pre.test(str)){
                strings.add(str);
            }
        }
        return strings;
    }
    // Function<T, R>: 函数型接口
    @Test
    public void test3() {
        Function<String, String> fun = x -> x.strip();
        System.out.println(fun.apply("\t\t\t  什么时候开始找工作  "));
    }


    // Supplier<T> 供给型接口
    @Test
    public void test2() {
        List<Integer> numList = getNumList(10, () -> (int)(Math.random() * 100));
        System.out.println(numList);
    }

    // 产生指定个数的整数，并放入集合中
    public List<Integer> getNumList(int num, Supplier<Integer> sup){
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<num; i++){
            Integer v = sup.get();
            list.add(v);
        }
        return list;
    }

    @Test
    public void test1() {
        // Consumer<T> 消费型接口
        Consumer<Double> con = x -> System.out.println(x);
        con.accept(100.0);
    }
}
