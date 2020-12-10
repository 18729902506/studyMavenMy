package com.datetest;

import lombok.Data;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/***
 * @author shang
 * LocalDateTime 年月日时分秒  yyyy-MM-dd : HH:mm:ss
 * LocalDate 年月日（日期）    yyyy-MM-dd
 * LocalTime 时间              HH:mm:ss
 */
@Data
public class DateTest {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd: HH:mm:ss");

    LocalDateTime localDateTime = LocalDateTime.from(FORMATTER.parse("2019-09-09: 10:02:30"));

    /***
     * 对于LocalDateTime类型，后面的时分秒不能省略，前端也必须传过来
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime create_time;

    /***
     * 对于LocalDate类型的，后面的时分秒可以加上，但是时分秒不能被接收和显示
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate select_time;

    public static void main(String[] args) {
        Date date1 = new Date();
        Date date2 = new Date();
        //true  检查两个日期对象是否为同一天，忽略时间的比较，只是比较是否是同一天，如果是同一天，则返回true
        System.out.println(DateUtils.isSameDay(date1,date2));

        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        //true   检查两个日期对象是否为同一天，忽略时间的比较
        System.out.println(DateUtils.isSameDay(calendar1,calendar2));
    }
}
