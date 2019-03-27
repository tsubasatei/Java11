package com.xt.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * 一、Lambda 表达式的基础语法：Java8中引入了一个新的操作符 "->" 该操作符称为箭头操作符或 Lambda 操作符。
 * 箭头操作符将 Lambda 表达式拆分为两部分：
 *
 * 左侧： Lambda 表达式的参数列表
 * 右侧：Lambda 表达式中所需要执行的功能，即 Lambda 体
 *
 * 语法格式一：无参数，无返回值
 *      () -> System.out.println("Hello Lambda!");
 *
 * 语法格式二：有一个参数，无返回值
 *      (x) -> System.out.println(x);
 *
 * 语法格式三：若只有一个参数，小括号可以省略不写
 *     x -> System.out.println(x);
 *
 * 语法格式四：有两个以上的参数，有返回值，并且Lambda体中有多条语句
 *      Comparator<Integer> com = (x, y) -> {
 *             System.out.println("函数式接口");
 *             return Integer.compare(x, y);
 *       };
 *
 *  语法格式五：若 Lambda 体中只有一条语句，return 和 大括号都可以省略不写
 *      (x, y) -> Integer.compare(x, y)
 *
 *  语法格式六：Lambda 表达式的参数列表的数据类型可以省略不写，因为JVM编译器通过上下文推断出数据类型，即“类型推断”
 *      (Integer x, Integer y) -> Integer.compare(x, y)
 *
 *  上联：左右遇一括号省 （只有一个参数，只有一条语句）
 *  下联：左侧推断类型省
 *  横批：能省则省
 *
 *  二、Lambda 表达式需要“函数式接口”的支持
 *  函数式接口：接口中只有一个抽象方法的接口，称为函数式接口。
 *  可以使用注解 @FunctionalInterface 修饰，可以检查是否是函数式接口
 */
public class LambdaTest {

    @Test
    public void test8(){
        op(100l, 100l, (x, y) -> x+y);
        op(100l, 100l, (x, y) -> x*y);
    }

    public void op(Long l1, Long l2, MyFun3<Long, Long> myFun3) {
        System.out.println(myFun3.getValue(l1, l2));
    }

    @Test
    public void test7(){
        System.out.println(strHandler("\t \r\n  我是字符串 \n", x -> x.strip()));

        System.out.println(strHandler("abcVasd", x -> x.toUpperCase()));
    }

    // 处理字符串
    public String strHandler(String str, MyFun2 fun2){
        return fun2.getValue(str);
    }

    // 不支持变化
    /*List<Employee> emps = List.of(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );*/

    List<Employee> emps = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );

    @Test
    public void test6(){
        Collections.sort(emps, (e1, e2) -> {
            if(e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return -e1.getAge().compareTo(e2.getAge());
            }
        });

        emps.forEach(System.out::println);
    }

    @Test
    public void test5(){
        Integer o = operrate(100, x -> x * x);
        System.out.println(o);

        Integer o2 = operrate(50, x -> x + 200);
        System.out.println(o2);
    }

    public Integer operrate(Integer num, MyFun fun){
        return fun.getValue(num);
    }
    @Test
    public void test4(){
        String[] strings = {"aaa", "bbb", "ccc"};
//        String[] strings1;
//        string1 = {"aaa", "bbb", "ccc"};
    }
    @Test
    public void test3(){
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
    }

    @Test
    public void test2(){
        Comparator<Integer> com = (x, y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x, y);
        };

    }

    @Test
    public void test1(){
//        Consumer<String> con = (x) -> System.out.println(x);
        Consumer<String> con = x -> System.out.println(x);
        con.accept("小夕找到好工作！");
    }

    @Test
    public void test(){
        // jdk1.7前，必须声明是 final
        int num = 0;
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World! " + num);
            }
        };
        r.run();

        System.out.println("------------");

        Runnable r2 = () -> System.out.println("Hello Lambda! " + num);
        r2.run();
    }
}
