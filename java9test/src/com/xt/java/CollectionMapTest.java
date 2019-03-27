package com.xt.java;

import org.junit.Test;

import java.util.*;

/**
 * 只读集合
 */
public class CollectionMapTest {

    // jdk 9 创建只读集合
    @Test
    public void test2 () {
        List<Integer> list = List.of(1, 2, 3);
        list.forEach(System.out::println);

        Set<Integer> set = Set.of(1, 2, 4);
        set.forEach(System.out::println);

        // 方式一
        Map<String, Integer> map = Map.of("aa", 11, "bb", 22, "cc", 33);
        map.forEach((k, v) -> System.out.println(k + ":" + v));

        // 方式二
        Map<String, Integer> map1 = Map.ofEntries(Map.entry("aa", 11), Map.entry("bb", 22));
        System.out.println(map1);
    }

    // jdk 8 之前
    @Test
    public void test1 () {

        // List
        List<Integer> list = Arrays.asList(1, 2, 3);
//        list.add(4); // UnsupportedOperationException
        // 不可添加，但可修改
        list.set(0, 4);
        list.forEach(System.out::println);

        // 只读
        List<Integer> list1 = Collections.unmodifiableList(Arrays.asList(1, 2, 3));
        /*list1.add(4); // UnsupportedOperationException
        list1.set(0, 4);
        list1.forEach(System.out::println);*/

        // Set
        Set<Integer> set = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1, 2, 3)));
//        set.add(4); // UnsupportedOperationException
        set.forEach(System.out::println);

        // Map
        Map<Object, Object> map = Collections.unmodifiableMap(new HashMap<>() {
            {
                put("aa", 11);
                put("bb", 22);
                put("cc", 33);
            }
        });
        map.forEach((k, v) -> System.out.println(k + " : " + v));

    }
    @Test
    public void test () {
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("dd");

        // 调用 Collections 中的方法，将 list 变为只读的
        List<String> newList = Collections.unmodifiableList(list);
//        newList.add("ee"); // 不能执行，否则报异常 UnsupportedOperationException
        newList.forEach(System.out::println);
    }
}
