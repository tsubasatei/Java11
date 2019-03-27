package com.xt.java.java8;

import org.junit.Test;

import java.util.Optional;

/**
 * Optional 类
 *
 * Optional.of(T t) : 创建一个Optional 实例
 *
 * Optional.empty() : 创建一个空的Optional 实例
 *
 * Optional.ofNullable(T t):若t 不为null,创建Optional 实例,否则创建空实例
 *
 * isPresent() : 判断是否包含值
 *
 * orElse(T t) : 如果调用对象包含值，返回该值，否则返回t
 *
 * orElseGet(Supplier s) :如果调用对象包含值，返回该值，否则返回s 获取的值
 *
 * map(Function f): 如果有值对其处理，并返回处理后的Optional，否则返回Optional.empty()
 *
 * flatMap(Function mapper):与map 类似，要求返回值必须是Optional
 */
public class OptionalTest {

    @Test
    public void test3 () {
        Optional<Employee> op = Optional.ofNullable(new Employee(10, "张三", 28, 8888.88, Employee.Status.VACATION));

        /*Optional<String> s = op.map(Employee::getName);
        System.out.println(s.get());*/

        Optional<String> s1 = op.flatMap((e) -> Optional.of(e.getName()));
        System.out.println(s1.get());
    }

    @Test
    public void test2 () {
        Optional<Employee> op = Optional.ofNullable(null);
        /*if(op.isPresent()) {
            System.out.println(op.get());  // NoSuchElementException
        }*/

//        Employee emp = op.orElse(new Employee(10));

        Employee emp = op.orElseGet(Employee::new);
        System.out.println(emp);
    }

    @Test
    public void test1 () {
        // NoSuchElementException
        Optional<Object> op = Optional.empty();
        System.out.println(op.get());
    }

    @Test
    public void test () {
        // NullPointerException
        Optional<Employee> op = Optional.of(null);
        System.out.println(op.get());
    }

    // 例题
    @Test
    public void test5(){
        Man man = new Man();

        String name = getGodnessName(man);
        System.out.println(name);
    }

    //需求：获取一个男人心中女神的名字
    public String getGodnessName(Man man){
        if(man != null){
            Godness g = man.getGod();

            if(g != null){
                return g.getName();
            }
        }

        return "苍老师";
    }

    //运用 Optional 的实体类
    @Test
    public void test6(){
        Optional<Godness> godness = Optional.ofNullable(new Godness("林志玲"));

        Optional<NewMan> op = Optional.ofNullable(new NewMan(godness));
        String name = getGodnessName2(op);
        System.out.println(name);
    }

    public String getGodnessName2(Optional<NewMan> man){
        return man.orElse(new NewMan())
                .getGodness()
                .orElse(new Godness("苍老师"))
                .getName();
    }
}
