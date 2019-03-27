package com.xt.java8;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.*;

/**
 * 一、方法引用：若 Lambda 体中的内容有方法已经实现了，我们可以使用“方法引用”
 *          （可以理解为方法引用是 Lambda 表达式的另外一种表现形式）
 *
 *  主要有三种语法格式：
 *
 *  对象::实例方法名
 *
 *  类::静态方法名
 *
 *  类::实例方法名
 *
 *  注意：
 *  1）Lambda 体中调用方法的参数列表与返回值类型，要与函数式接口中抽象方法的函数列表和返回值类型保持一致
 *  2）若 Lambda 参数列表中的第一个参数是 实例方法的调用者， 而第二个参数是 实例方法的参数时，可以使用 ClassName::method
 *
 *  二、构造器引用：
 *
 *  ClassName::new
 *
 *  注意：需要调用的构造器的参数列表需与函数式接口中的抽象方法的参数列表保持一致！
 *
 *  三、数组引用
 *
 *  Type::new
 */
public class MethodRefTest {

    // 数组引用
    @Test
    public void test5() {
        Function<Integer, String[]> fun = (x) -> new String[x];
        System.out.println(fun.apply(10).length);

        Function<Integer, String[]> fun2 = String[]::new;
        System.out.println(fun2.apply(20).length);
    }

    // 构造器引用
    @Test
    public void test4(){
        Supplier<Employee> sup = () -> new Employee();

        Supplier<Employee> sup2 = Employee::new;
        System.out.println(sup2.get());

        System.out.println("------------");

        Function<Integer, Employee> fun = Employee::new;
        Employee employee = fun.apply(5);
        System.out.println(employee);

        BiFunction<Integer, Integer, Employee> bi = Employee::new;
        System.out.println(bi.apply(17, 29));
    }

    // 类::实例方法名
    @Test
    public void test3(){
        BiPredicate<String, String> bi = (x, y) -> x.equals(y);

        BiPredicate<String, String> bi2 = String::equals;
        System.out.println(bi2.test("abc", new String("abc")));
    }

    // 类::静态方法名
    @Test
    public void test2(){
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);

        Comparator<Integer> com1 = Integer::compareTo;
        System.out.println(com1.compare(20, 30));
    }

    @Test
    public void test1(){
        Employee emp = new Employee(1, "zhangsan", 18, 10000.0);
        Supplier<String> sup = emp::getName;
        System.out.println(sup.get());

        Supplier<Integer> sup1 = emp::getAge;
        System.out.println(sup1.get());

    }

    // 对象::实例方法名
    @Test
    public void test(){
        PrintStream ps = System.out;
        Consumer<String> con = (x) -> ps.println(x);
        con.accept("abc");

        Consumer<String> con1 = ps::println;
        con1.accept("qwe");

        Consumer<String> con2 = System.out::println;
        con2.accept("zxc");
    }
}
