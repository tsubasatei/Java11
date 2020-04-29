package com.xt.java;


import com.xt.java.bean.Person;
import org.junit.Test;

import java.util.logging.Logger;

/**
 * 测试 java 9 的模块化特性
 */
public class ModuleTest {

    public static final Logger logger = Logger.getLogger("xt");

    public static void main(String[] args) {
        Person person = new Person("Tom", 16);
        System.out.println(person);

        logger.info("这是info级别日志");
    }
    
    @Test
    public void test () {
        
    }
}
