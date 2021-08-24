package com.lee.datastructureandalgorithms.problems;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class DateDemo {
    public static void main(String[] args) {
//        String name = null;
//        Objects.requireNonNull(name, "Name can't be null");

        LocalDate localDate = LocalDate.parse("2020-06-01");
        System.out.println("localDate = " + localDate);

        LocalTime localTime = LocalTime.parse("12:23:44");
        System.out.println("localTime = " + localTime);

        DateTimeFormatter dateFormatter
                = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate localDateFormatted
                = LocalDate.parse("01.06.2020", dateFormatter);
        System.out.println("localDateFormatted = " + localDateFormatted);

        DateTimeFormatter timeFormatter
                = DateTimeFormatter.ofPattern("HH|mm|ss");
        LocalTime localTimeFormatted
                = LocalTime.parse("12|23|44", timeFormatter);
        System.out.println("localTimeFormatted = " + localTimeFormatted);

        System.out.println("-----------------------------");
        // yyyy-MM-dd HH:mm:ss
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatterLocalDateTime
                = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String stringLDT
                = formatterLocalDateTime.format(localDateTime);
        System.out.println("stringLDT = " + stringLDT);

        // or shortly
        String stringLDTShort = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("stringLDTShort = " + stringLDTShort);

        Instant timestamp = Instant.now();
        System.out.println("timestamp = " + timestamp);

        Period fromDays = Period.ofDays(120);
        System.out.println("fromDays = " + fromDays);

        LocalDate startLocalDate = LocalDate.of(2018, 3, 12);
        LocalDate endLocalDate = LocalDate.of(2019, 7, 20);
        Period periodBetween = Period.between(startLocalDate, endLocalDate);
        System.out.println("periodBetween = " + periodBetween);

        long unixTimestamp = 1573768800;
        // 2019-11-14T22:00:00Z in UTC
        Instant instant = Instant.ofEpochSecond(unixTimestamp);
        // Fri Nov 15 00:00:00 EET 2019 - in the default time zone
        Date date = Date.from(instant);
        System.out.println("date = " + date);


        LocalDate date1 = LocalDate.of(2019, Month.FEBRUARY, 27);
        // 2019-02-01
        LocalDate firstDayOfFeb = date1.with(TemporalAdjusters.firstDayOfMonth());
        // 2019-02-28
        LocalDate lastDayOfFeb = date1.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("firstDayOfFeb = " + firstDayOfFeb);
        System.out.println("lastDayOfFeb = " + lastDayOfFeb);

//        Date date = new Date();
//        // e.g., 2019-02-27T12:02:49.369Z, UTC
//        Instant instantFromDate = date.toInstant();
//
//        Instant instant = Instant.now();
//        // Wed Feb 27 14:02:49 EET 2019, default system time zone
//        Date dateFromInstant = Date.from(instant);

        LocalDate localDate1 = LocalDate.of(2019, 2, 28);
//        LocalDateTime ldDayStart = localDate1.atStartOfDay();
        LocalDateTime ldDayStart = LocalDateTime.of(localDate, LocalTime.MIN);
        LocalDateTime ldDayEnd = localDate.atTime(LocalTime.MAX);
        System.out.println(ldDayStart);
        System.out.println("ldDayEnd = " + ldDayEnd);


    }
}
