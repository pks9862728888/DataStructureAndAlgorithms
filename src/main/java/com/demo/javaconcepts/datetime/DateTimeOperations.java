package com.demo.javaconcepts.datetime;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Slf4j
public class DateTimeOperations {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        log.info("LocalDate.now(): {}", localDate);
    }
}
