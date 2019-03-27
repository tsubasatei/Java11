package com.xt.java.java8;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 传统的时间 存在线程安全问题
 */
public class TestSimpleDataFormat {
    public static void main(String[] args) throws Exception {
        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

		Callable<Date> task = () -> sdf.parse("20161121");

		ExecutorService pool = Executors.newFixedThreadPool(10);

		List<Future<Date>> results = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			results.add(pool.submit(task));
		}

		for (Future<Date> future : results) {
			System.out.println(future.get());
		}

		pool.shutdown();*/


        //解决多线程安全问题
		/*Callable<Date> task = () -> DateFormatThreadLocal.convert("20161121");

		ExecutorService pool = Executors.newFixedThreadPool(10);

		List<Future<Date>> results = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			results.add(pool.submit(task));
		}

		for (Future<Date> future : results) {
			System.out.println(future.get());
		}

		pool.shutdown();*/

		// Java 8

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        Callable<LocalDate> task = new Callable<LocalDate>() {
            @Override
            public LocalDate call() throws Exception {
                LocalDate ld = LocalDate.parse("20190327", dtf);
                return ld;
            }
        };
        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future<LocalDate>> result = new ArrayList<>();

        for(int i=0; i<10; i++){
            result.add(pool.submit(task));
        }

        for (Future<LocalDate> future : result) {
            System.out.println(future.get());
        }

        pool.shutdown();
    }
}
