package Util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    public static String returnNow_date() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String now = localDate.format(dtf);
        System.out.println(now);
        return now;
    }

    public static String returnNow_datetime() {
        LocalDateTime localDatetime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String now = localDatetime.format(dtf);
        System.out.println(now);
        return now;
    }

    public static String returnNow_time(){
        LocalTime localTime=LocalTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("HH:mm:ss");
        String now =localTime.format(dtf);
        System.out.println(now);
        return now;
    }




    public static void main(String[] args) {
        returnNow_time();
    }
}
