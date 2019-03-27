package com.xt.java.java8;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

/**
 * 日期
 */
public class LocalDateTimeTest {

    // ZonedDate ZonedTime ZonedDateTime
    @Test
    public void test6 () {
        LocalDateTime ldt = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println(ldt);

        LocalDateTime ldt2 = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        ZonedDateTime zdt = ldt2.atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(zdt);
    }
    @Test
    public void test5 () {
        Set<String> set = ZoneId.getAvailableZoneIds();
        set.forEach(System.out::println);
    }

    // 5. DateTimeFormatter ： 格式化日期和时间
    @Test
    public void test4 () {
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
        LocalDateTime ldt = LocalDateTime.now();

        String strDate = ldt.format(dtf);
        System.out.println(strDate);

        System.out.println("--------------");

        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy年-MM月-dd日 HH:mm:ss");
        String strDate2 = dtf2.format(ldt);
        System.out.println(strDate2);

        LocalDateTime ldt2 = LocalDateTime.parse(strDate2, dtf2);
        System.out.println(ldt2);

    }

    // 4. TemporalAdjuster : 时间校正器
    @Test
    public void test3 () {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        LocalDateTime ldt2 = ldt.withDayOfMonth(10);
        System.out.println(ldt2);

        LocalDateTime ldt3 = ldt.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(ldt3);

        // 自定义下一个工作日
        LocalDateTime ldt5 = ldt.with(l -> {
            LocalDateTime ldt4 = (LocalDateTime) l;
            DayOfWeek dayOfWeek = ldt4.getDayOfWeek();
            if (dayOfWeek.equals(DayOfWeek.FRIDAY)) {
                return ldt4.plusDays(3);
            } else if (dayOfWeek.equals(DayOfWeek.SATURDAY)) {
                return ldt4.plusDays(2);
            } else {
                return ldt4.plusDays(1);
            }

        });
        System.out.println(ldt5);

    }

    // 3. 计算间隔
    // Duration ：计算两个 时间 之间的间隔
    // Period ： 计算两个 日期 之间的间隔
    @Test
    public void test2 () {
        Instant start = Instant.now();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println(duration.toMillis());

        System.out.println("---------");

        LocalTime lt1 = LocalTime.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LocalTime lt2 = LocalTime.now();

        System.out.println(Duration.between(lt1, lt2).getSeconds());

        System.out.println("-----------");

        LocalDate ld = LocalDate.of(2016, 3, 29);
        LocalDate ld2 = LocalDate.now();

        Period period = Period.between(ld, ld2);
        System.out.println(period);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
    }


    // 2. Instant ：时间戳（以 Unix 元年：1970年1月1日 00:00:00 到某个时间之间的毫秒值）
    @Test
    public void test1 () {
        Instant instant = Instant.now();
        System.out.println(instant);

        OffsetDateTime odt = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(odt);

        System.out.println(instant.toEpochMilli());

        Instant instant1 = Instant.ofEpochMilli(60);
        System.out.println(instant1);

    }

    // 1. LocalDate  LocalTime LocalDateTime 方法一样
    @Test
    public void test () {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        LocalDateTime ldt2 = LocalDateTime.of(2018, 12, 12, 23, 59, 30);
        System.out.println(ldt2);

        LocalDateTime ldt3 = ldt.plusYears(2);
        System.out.println(ldt3);

        LocalDateTime ldt4 = ldt.minusMonths(2);
        System.out.println(ldt4);

        System.out.println(ldt.getYear());
        System.out.println(ldt.getMonth());
        System.out.println(ldt.getMonthValue());
        System.out.println(ldt.getDayOfMonth());
        System.out.println(ldt.getHour());

    }
}
