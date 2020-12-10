package com.datetest;

import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/***
 * 梳理日期在代码中的应用（参照畅哥的java8工程）
 * @author shang
 * @date 2020-09-09
 */
public class LocalDateTest {

    private int year = 2020;
    private int month = 9;
    private int day = 10;
    private String calendarStr = "2020-09-10";
    private LocalDate calendarLocalDate = LocalDate.parse(calendarStr);

    @Test
    public void getNow() {
        LocalDate now = LocalDate.now();
        //LocalData转化为String
        System.out.println(now.toString());
    }

    @Test
    public void initLocalDate() {
        LocalDate date2 = LocalDate.of(year, month, day);
        //日期相等可以用equals()进行判断，date1.equals(date2)    不相同时，就会打印message的消息内容，相同时，不用打印
        Assert.assertEquals("不相同", calendarLocalDate, date2);
        Assert.assertEquals(calendarLocalDate, date2);
    }

    @Test
    public void string2LocalDate() {
        //默认格式 yyyy-MM-dd
        LocalDate localDate1 = LocalDate.parse(calendarStr);
        String dateStr2 = "20200910";
        LocalDate localDate2 = LocalDate.parse(dateStr2, DateTimeFormatter.ofPattern("yyyyMMdd"));
        Assert.assertEquals(localDate1, localDate2);
    }

    @Test
    public void localDate2String() {
        LocalDate now = LocalDate.now();
        String nowStr = now.toString();
        //打印出默认格式 2020-09-10
        System.out.println(nowStr);
        String otherStr = now.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        //打印出转化后的格式 20200910
        System.out.println(otherStr);
    }

    @Test
    public void localDate2Date() {
        LocalDate localDate = LocalDate.now();
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        //打印出的时间格式是 Thu Sep 10 00:00:00 CST 2020
        System.out.println(date);
        System.out.println(date.toString());
        //如果格林威治时间是Date格式，转换为正常的时间格式 2020-09-10
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(dateFormat.format(date));
    }

    @Test
    public void date2LocalDate() {
        Date date = new Date();
        //2020-09-10
        System.out.println(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
    }

    @Test
    public void getYearMonthDay() {
        LocalDate date = LocalDate.of(year, month, day);
        Assert.assertEquals("aaa", year, date.getYear());
        Assert.assertEquals("bbb", month, date.getMonth().getValue());
        Assert.assertEquals("ccc", month, date.getMonthValue());
        //返回的是day
        Assert.assertEquals("ccc", day, date.getDayOfMonth());
        //获取日期所在周的周一   2020-09-07
        System.out.println(LocalDate.now().with(DayOfWeek.MONDAY));
    }

    @Test
    public void plusOrMinus() {
        Assert.assertEquals(LocalDate.parse(calendarStr), LocalDate.of(2019, 8, 11).plusYears(1).plusMonths(1).minusDays(1));
    }

    /***
     * 获取月 年的第一天或者最后一天
     */
    @Test
    public void getFirstOrLastDay() {
        LocalDate now = LocalDate.now();
        //获取本月的第一天  2020-09-01
        System.out.println(now.with(TemporalAdjusters.firstDayOfMonth()));

        //获取本月的最后一天  2020-09-30
        System.out.println(now.with(TemporalAdjusters.lastDayOfMonth()));

        //下个月第一天   2020-10-01
        System.out.println(now.with(TemporalAdjusters.firstDayOfNextMonth()));

        //本年的最后一天  2020-12-31
        System.out.println(now.with(TemporalAdjusters.lastDayOfYear()));

        //本季度第一天   2020-07-01
        System.out.println(LocalDate.of(now.getYear(), now.getMonth().firstMonthOfQuarter(), 1));

        //本季度第二天   2020-07-02
        System.out.println(LocalDate.of(now.getYear(), now.getMonth().firstMonthOfQuarter(), 2));
    }

    /***
     * 计算两个日期相差
     */
    @Test
    public void testBetween() {
        //相差天数  2020-10-11
        LocalDate laterDate = LocalDate.of(year, month + 1, day + 1);
        Period period = Period.between(calendarLocalDate, laterDate);
        //注意这里和通常理解的相差天数不同
        Assert.assertEquals("aaa", 1, period.getDays());

        //获取实际的相差天数，until()底层就是toEpochDay()  后面的-前面的
        Assert.assertEquals(31, calendarLocalDate.until(laterDate, ChronoUnit.DAYS));
        Assert.assertEquals(-31, laterDate.until(calendarLocalDate, ChronoUnit.DAYS));
        Assert.assertEquals(31, laterDate.toEpochDay() - calendarLocalDate.toEpochDay());

        //相差月份
        Period monthPeriod1 = Period.between(LocalDate.parse("2020-02-14"), LocalDate.parse("2020-03-13"));
        Period monthPeriod2 = Period.between(LocalDate.parse("2020-02-14"), LocalDate.parse("2020-03-14"));
        Assert.assertEquals(0, monthPeriod1.getMonths());
        Assert.assertEquals(1, monthPeriod2.getMonths());
    }
}
