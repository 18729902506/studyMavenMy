package com.datetest;

import org.junit.Assert;
import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/***
 * @author shang
 * @Description LocalDateTimeTest is userd to Java8中的时间类
 */
public class LocalDateTimeTest {

    public static void main(String[] args) {

        LocalDateTime.now();
        //Asia/Shanghai    获取系统的默认时区
        System.out.println(ZoneId.systemDefault());
//        LocalDateTime.now().isAfter();   比较时间先后
    }

    /**
     * 将Date转化为LocalDateTime
     */
    public static LocalDateTime convertDateToLDT(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    public static long betweenTwoTime(LocalDateTime startTime, LocalDateTime endTime, ChronoUnit field) {
        Period period = Period.between(LocalDate.from(startTime), LocalDate.from(endTime));
        if (field == ChronoUnit.YEARS) {
            return period.getYears();
        }
        if (field == ChronoUnit.MONTHS) {
            return period.getYears() * 12 + period.getMonths();
        }
        return field.between(startTime, endTime);
    }

    @Test
    public void testPlus() {
        //2019-09-09
        LocalDate today = LocalDate.now();
        System.out.println("current date：" + today);

        //获取当月的第一天和最后一天
        //2019-09-01    2019-09-30
        System.out.println(today.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println(today.with(TemporalAdjusters.lastDayOfMonth()));


        //2019-09-16
        LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
        System.out.println("next week：" + nextWeek);

        long diff = ChronoUnit.WEEKS.between(today, nextWeek);
        //判断两个对象是否相等，如果相等，程序继续往下走，不相等时，中断程序，抛出异常信息
        Assert.assertEquals(1, diff);

        //2019-10-09
        LocalDate nextMonth = today.plus(1, ChronoUnit.MONTHS);
        System.out.println("next month：" + nextMonth);

        //2020-09-09
        LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
        System.out.println("next year：" + nextYear);

        //2029-09-09
        LocalDate nextTenYear = today.plus(1, ChronoUnit.DECADES);
        System.out.println("next Ten year：" + nextTenYear);
    }


    /***
     * 获取当前日期时间
     */
    @Test
    public void getNow() {
        LocalDateTime now = LocalDateTime.now();
        //2020-09-10T11:37:30.320
        System.out.println(now);
    }

    /***
     * 日期时间转字符串
     */
    @Test
    public void localDateTime2String() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //2020-09-10 11:37:11
        System.out.println(dateTimeFormatter.format(now));
    }

    /***
     * 字符串转日期时间
     */
    @Test
    public void string2LocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.parse("2020-09-10 11:37:11", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        //2020-09-10T11:37:11
        System.out.println(localDateTime);
    }

    /***
     * localDateTime转化为localDate
     */
    @Test
    public void localDateTime2LocalDate() {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = localDateTime.toLocalDate();
        //2020-09-10
        System.out.println(localDate);
    }

    @Test
    public void date2LocalDateTime() {
        Date date = new Date();
        //2020-09-10T13:28:20.308
        System.out.println(LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()));
    }

    @Test
    public void localDateTime2Date() {
        LocalDateTime localDateTime = LocalDateTime.now();
        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        //Thu Sep 10 13:29:16 CST 2020
        System.out.println(date);
    }

    @Test
    public void minusOrPlus() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime yesterday = now.minusDays(1L);
        //2020-09-09T13:31:46.717       2020-09-10T13:31:46.717  加减并不会改变日期本身
        System.out.println(yesterday);
        System.out.println(now);
    }

    /***
     * 比较两个日期前后
     */
    @Test
    public void testCompare() {
        LocalDateTime now = LocalDateTime.now();
        Assert.assertTrue(now.isBefore(now.plusDays(1L)));
        Assert.assertFalse(now.isBefore(now));
        Assert.assertTrue(now.isEqual(now));
    }

    /***
     *计算两个日期相差
     */
    @Test
    public void testBetween() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime tomorrow = LocalDateTime.now().plusDays(1).plusMonths(1);
        //注意参数的顺序，
        Duration duration = Duration.between(now, tomorrow);
        Assert.assertEquals(31, duration.toDays());
        Assert.assertEquals(31 * 24, duration.toHours());
    }

    /**
     * 取某个时间内的最大最小日期
     */
    @Test
    public void testMaxMin() {
        LocalDateTime now = LocalDateTime.now();
        //取本月第一天的最小时分秒      2020-09-01T00:00
        System.out.println(now.with(TemporalAdjusters.firstDayOfMonth()).with(LocalTime.MIN));
        //取本月最后一天的最大时分秒    2020-09-30T23:59:59.999999999
        System.out.println(now.with(TemporalAdjusters.lastDayOfMonth()).with(LocalTime.MAX));
    }
}