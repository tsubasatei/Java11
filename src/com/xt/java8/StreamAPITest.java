package com.xt.java8;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 一、Stream 的三个操作步骤
 *
 * 1. 创建 Stream
 *
 * 2. 中间操作
 *
 * 3. 终止操作（终端操作）
 */
public class StreamAPITest {

    List<Employee> emps = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99, Employee.Status.REEE),
            new Employee(102, "李四", 59, 6666.66, Employee.Status.BUSY),
            new Employee(103, "王五", 28, 3333.33, Employee.Status.VACATION),
            new Employee(104, "赵六", 8, 7777.77, Employee.Status.REEE),
            new Employee(105, "田七", 38, 5555.55, Employee.Status.BUSY)
    );

    // 创建 Stream
    @Test
    public void test(){
        // 1. 可以通过 Collection 系列集合提供的 stream()(串行) 或 parallelStream()(并行)
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        // 2. 通过 Arrays 中的静态方法 stream() 获取数组流
        Employee[] emps = new Employee[10];
        Stream<Employee> stream1 = Arrays.stream(emps);

        // 3. 通过 Stream 类中的静态方法 of()
        Stream<String> stream2 = Stream.of("aa", "bb", "cc");

        // 4. 创建无限流
        // 4.1 迭代
        Stream<Integer> stream3 = Stream.iterate(0, x -> x + 2);
        stream3.limit(10).forEach(System.out::println);

        System.out.println("--------");
        Stream<Integer> stream4 = Stream.iterate(0, x -> x < 20, x -> x + 2);
        stream4.forEach(System.out::println);

        System.out.println("-------");
        // 4.2 生成
        Stream<Double> stream5 = Stream.generate(() -> Math.random());
        stream5.limit(5).forEach(System.out::println);
    }

    // 中间操作

    /**
     * 排序
     *
     * sorted(): 自然排序
     * sorted(Comparator com): 定制排序
     */
    @Test
    public void test6 () {
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().sorted().forEach(System.out::println);

        System.out.println("----------");
        emps.stream().sorted((e1, e2) -> {
            if(e1.getAge() == e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }else {
                return e1.getAge().compareTo(e2.getAge());
            }
        }).forEach(System.out::println);
    }

    /**
     * 映射
     *
     * map: 接收 Lambda, 将元素转换成其他形式或提取信息。
     *      接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一根新的元素。
     *
     * flatMap: 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有的流连接成一个流
     *
     */
     @Test
     public void test5 () {
         List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
         list.stream()
                 .map(str -> str.toUpperCase())
                 .forEach(System.out::println);

         emps.stream()
                 .map(Employee::getName)
                 .forEach(System.out::println);

         System.out.println("----------------");

         // {{a,a}, {b,b}}
         Stream<Stream<Character>> stream = list.stream()
                 .map(StreamAPITest::filterStr);
         stream.forEach(sm -> sm.forEach(System.out::println));

         // {a,a,b,b}
         System.out.println("--------");
         Stream<Character> stream1 = list.stream()
                 .flatMap(StreamAPITest::filterStr);
         stream1.forEach(System.out::println);
     }

    public static Stream<Character> filterStr(String str){
         List<Character> list = new ArrayList<>();

         for(Character ch : str.toCharArray()) {
             list.add(ch);
         }
         return list.stream();
    }

    /**
     * 筛选与切片
     *
     * filter：接受 Lambda，从流中排除某些元素。
     *
     * limit：截断流，使其元素不超过给定数量。
     *
     * skip(n): 跳过元素，返回一个扔掉了前 n 个元素的流。
     *          若流中元素不足 n 个，则返回一个空流。
     *
     * distinct：筛选，通过流所生成元素的 hasCode() 和 equals() 去除重复元素
     */

    // 内部迭代：迭代操作由 Stream API 完成
    @Test
    public void test1 () {
        // 中间操作：不会执行任何操作
        Stream<Employee> stream = emps.stream().filter(e -> {
            System.out.println("Streamm API 的中间操作");
            return e.getAge() > 35;
        });
        // 终止操作：一次性执行全部内容，即“惰性求值”
        stream.forEach(System.out::println);
    }

    // 外部迭代
    @Test
    public void test2 () {
        Iterator<Employee> iterator = emps.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test3 () {
        emps.stream()
                .filter(e -> {
                        System.out.println("短路");
                        return e.getSalary() > 5000;
                    })
                .limit(2)
                .forEach(System.out::println);
    }

    @Test
    public void test4 () {
        emps.stream()
                .filter(e -> e.getSalary() > 5000)
                .skip(2)
                .distinct()
                .forEach(System.out::println);
    }



    // 终止操作

    /**
     * 收集
     *
     * collect: 将流转换为其他形式。接收一个 Collector 接口的实现，用于给 Stream 中元素做汇总的方法。
     */

    @Test
    public void test14 () {
        String collect = emps.stream().map(Employee::getName).collect(Collectors.joining(",", "===", "---"));
        System.out.println(collect);
    }

    @Test
    public void test13 () {
        DoubleSummaryStatistics collect = emps.stream().collect(Collectors.summarizingDouble(Employee::getSalary));

        System.out.println(collect.getMax());
        System.out.println(collect.getAverage());
        System.out.println(collect.getCount());
    }

    // 分区
    @Test
    public void test12 () {
        Map<Boolean, List<Employee>> collect = emps.stream().collect(Collectors.partitioningBy(x -> x.getSalary() > 5000));
        System.out.println(collect);
    }

    @Test
    public void test11 () {

        // 分组
        Map<Employee.Status, List<Employee>> group = emps.stream().collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(group);

        System.out.println("--------------");

        // 多级分组
        Map<Employee.Status, Map<String, List<Employee>>> map = emps.stream().collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((x) -> {
            if (x.getAge() < 35) {
                return "青年";
            } else if (x.getAge() < 50) {
                return "中年";
            } else {
                return "老年";
            }
        })));
        System.out.println(map);

    }

    @Test
    public void test10 () {
        // 总数
        Long count = emps.stream().collect(Collectors.counting());
        System.out.println(count);

        System.out.println("--------------");

        // 平均值
        Double avg = emps.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(avg);

        System.out.println("--------------");

        // 总和
        Double sum = emps.stream().collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(sum);

        // 最大值
        Optional<Employee> max = emps.stream().collect(Collectors.maxBy((x, y) -> Double.compare(x.getSalary(), y.getSalary())));
        System.out.println(max.get());

        // 最小值
        Optional<Double> min = emps.stream().map(Employee::getSalary)
                .collect(Collectors.minBy(Double::compare));
        System.out.println(min.get());
    }

    @Test
    public void test9 () {
        List<String> list = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        list.stream().forEach(System.out::println);

        System.out.println("---------------");

        Set<String> set = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());
        set.stream().forEach(System.out::println);

        System.out.println("---------------");

        HashSet<String> hs = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));
        hs.stream().forEach(System.out::println);
    }

    /**
     * 归约
     *
     * reduce(T identity, BinaryOperator) / reduce(BinaryOperator):
     * 可以将流中元素反复结合起来，得到一个值
     */
    @Test
    public void test8 () {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = list.stream()
                .reduce(0, (e1, e2) -> e1 + e2);
        System.out.println(reduce);

        System.out.println("------------");

        Optional<Double> reduce1 = emps.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);
        System.out.println(reduce1.get());
    }

    /**
     * 查找与匹配
     *
     * allMatch: 检查是否匹配所有的元素
     * anyMatch: 检查是否至少匹配一个元素
     * noneMatch: 检查是否没有匹配所有元素
     * findFirst: 返回第一个元素
     * findAny: 返回当前流中的任意元素
     * count: 返回流中元素的总个数
     * max: 返回流中的最大值
     * min: 返回流中的最小值
     */
    @Test
    public void test7 () {
        boolean b = emps.stream()
                .allMatch(e -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b);

        boolean b1 = emps.stream()
                .anyMatch(e -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b1);

        boolean b2 = emps.stream()
                .noneMatch(e -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b2);

        Optional<Employee> first = emps.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .findFirst();
        System.out.println(first.get());

        Optional<Employee> optional = emps.parallelStream()
                .filter(e -> e.getStatus().equals(Employee.Status.REEE))
                .findAny();
        System.out.println(optional.get());

        long count = emps.stream().count();
        System.out.println(count);

        Optional<Employee> max = emps.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));
        System.out.println(max.get());

        Optional<Double> min = emps.stream()
                .map(Employee::getSalary)
                .min(Double::compareTo);
        System.out.println(min.get());
    }

}
