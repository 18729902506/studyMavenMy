package com.datetest;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/***
 * @author shang
 * @date 2020-09-10
 */
public class LocalTimeTest {

    @Test
    public void localTime2String(){
        LocalTime localTime = LocalTime.now();
        //打印出当前是几点几分  13:48
        System.out.println(DateTimeFormatter.ofPattern("HH:mm").format(localTime));
    }

    @Test
    public void localDateTime2LocalTime(){
        LocalTime localTime = LocalDateTime.now().toLocalTime();
        //13:51:24.711
        System.out.println(localTime);
    }
}
