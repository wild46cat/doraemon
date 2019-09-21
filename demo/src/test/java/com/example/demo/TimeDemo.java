package com.example.demo;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


/**
 * Created by wuxueyou on 2018/9/18.
 * joda Time demo
 */
public class TimeDemo {
    public static void main(String[] args) {
        System.out.println(123);
//      日期to字符串
        DateTime dateTime = new DateTime();

        System.out.println(dateTime.getMillis());
        System.out.println(dateTime.toString("YYYY-MM-dd HH:mm:ss.SSS"));
        System.out.println(dateTime.getMillis());
//        日期加减
        DateTime dateTime2 = dateTime.plusDays(2);
        System.out.println(dateTime.toString("YYYY-MM-dd HH:mm:ss.SSS"));
        System.out.println(dateTime.getMillis());
        System.out.println(dateTime2.toString("YYYY-MM-dd HH:mm:ss.SSS"));
        System.out.println(Days.daysBetween(dateTime2, dateTime).getDays());
//        字符串to日期
        String dateStr = "2018-12-12 00:12:13.333";
        DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY-MM-dd HH:mm:ss.SSS");
        DateTime dateTime3 = DateTime.parse(dateStr, fmt);
        System.out.println(dateTime3);
        System.out.println(dateTime3.getHourOfDay());

        DateTime dateTime1 = new DateTime(57620000);
        System.out.println(dateTime1.toString("mm:ss"));
        System.out.println("aaa=====");
        String dateStr1 = "2019-04-02";
        String dateStr2 = "2019-04-09";
        System.out.println(daysBetweenOverMax(dateStr1, dateStr2, 7));
        System.out.println(String.format("%.2f",100 * 0.0007315));
    }

    public static boolean daysBetweenOverMax(String dateStrStart, String dateStrEnd, int max) {
        DateTimeFormatter fmt2 = DateTimeFormat.forPattern("yyyy-MM-dd");
        DateTime dateTimeStart = DateTime.parse(dateStrStart, fmt2);
        DateTime dateTimeEnd = DateTime.parse(dateStrEnd, fmt2);
        return Math.abs(Days.daysBetween(dateTimeStart, dateTimeEnd).getDays()) > max;

    }
}
