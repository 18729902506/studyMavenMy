package com.threadtest.demo.mdctest;

import org.junit.Assert;
import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * @author s
 */
public class LocalDateTimeTest {

    /**
     * 获取当前日期时间
     */
    @Test
    public void getNow() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
    }

    /**
     * 日期时间转字符串
     */
    @Test
    public void localDateTime2String() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateTimeFormatter.format(now));
    }

    /**
     * 字符串转日期时间
     */
    @Test
    public void string2LocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.parse("2018-01-12 17:07:05",
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(localDateTime);
    }

    /**
     * LocalDateTime转LocalDate
     */
    @Test
    public void localDateTime2LocalDate() {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = localDateTime.toLocalDate();
        System.out.println(localDate);
    }

    @Test
    public void date2LocalDateTime() {
        Date date = new Date();
        System.out.println(LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()));
    }

    @Test
    public void localDateTime2Date() {
        LocalDateTime localDateTime = LocalDateTime.now();
        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(date);
    }

    /**
     * 日期加减
     */
    @Test
    public void minusOrPlus() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime yesterday = now.minusDays(1L);
        System.out.println(yesterday);
        //加减并不会改变日期本身
        System.out.println(now);
    }

    /**
     * 比较两个日期前后
     */
    @Test
    public void testCompare() {
        LocalDateTime now = LocalDateTime.now();
        Assert.assertTrue(now.isBefore(now.plusDays(1L)));
        Assert.assertFalse(now.isBefore(now));
        Assert.assertTrue(now.isEqual(now));
    }

    /**
     * 计算两个日期相差
     */
    @Test
    public void testBetween() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime tomorrow = LocalDateTime.now().plusDays(1L).plusMonths(1L);
        //注意参数顺序
        Duration duration = Duration.between(now, tomorrow);
        Assert.assertEquals(32, duration.toDays());
        Assert.assertEquals(32 * 24, duration.toHours());
    }

    /**
     * 取某个时间内的最大最小日期
     */
    @Test
    public void testMaxMin() {
        LocalDateTime now = LocalDateTime.now();
        //取本月第一天的最小时分秒
        System.out.println(now.with(TemporalAdjusters.firstDayOfMonth()).with(LocalTime.MIN));
        //取本月最后一天的最大时分秒
        System.out.println(now.with(TemporalAdjusters.lastDayOfMonth()).with(LocalTime.MAX));
    }

}
