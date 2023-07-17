package com.demo.javaconcepts.datetime;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;

@Slf4j
public class DateTimeOperations {

    public static void main(String[] args) {
        // Using .now()
        LocalDate localDate = LocalDate.now();
        log.info("LocalDate.now(): {}", localDate);

        LocalTime localTime = LocalTime.now();
        log.info("LocalTime.now(): {}", localTime);

        LocalDateTime localDateTime = LocalDateTime.now();
        log.info("LocalDateTime.now(): {}", localDateTime);

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        log.info("ZonedDateTime.now(): {}", zonedDateTime);

        // Using .of() method
        LocalDate localDate1 = LocalDate.of(2023, 1, 1);
        log.info("LocalDate.of(): {}", localDate1);

        LocalTime localTime1 = LocalTime.of(1, 1, 1, 1);
        log.info("LocalTime.of(): {}", localTime1);

        LocalDateTime localDateTime1 = LocalDateTime.of(2023, 1, 1, 1, 1, 1, 1);
        log.info("LocalDateTime.of(): {}", localDateTime1);

        ZonedDateTime zonedDateTime1 = ZonedDateTime.of(localDateTime, ZoneId.of("Australia/Sydney"));
        log.info("ZonedDateTime.of(): {}", zonedDateTime1);

        // Duration
        LocalTime now = LocalTime.now();
        LocalTime notNow = now.plusHours(1)
                .plusMinutes(3)
                .plusSeconds(1)
                .plusNanos(1);
        Duration duration = Duration.between(now, notNow);
        log.info("Duration: {}", duration);

        // Period
        Period period = Period.of(1, 1, 1);
        log.info("Period: {}", period);
        log.info("Days part in period: {}", period.getMonths());
        log.info("Days part in period: {}", period.get(ChronoUnit.DAYS));

        // DateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE LLLL");
        log.info("LocalDateTime: {} formatted to: {}", localDateTime, localDateTime.format(formatter));
        log.info("LocalTime: {} formatted to: {}", localTime,
                localTime.format(DateTimeFormatter.ofPattern("HH-mm-ss.SSSSSS")));
    }
}




















