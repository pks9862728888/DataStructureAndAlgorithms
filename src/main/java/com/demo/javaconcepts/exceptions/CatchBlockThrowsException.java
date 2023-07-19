package com.demo.javaconcepts.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CatchBlockThrowsException {

    public static void main(String[] args) {
        try {
            log.info("try");
            throw new RuntimeException("try exception!");
        } catch (Exception e) {
            log.info("catch exception");
            throw new RuntimeException("Another exception from catch!");
        } finally {
            log.info("Finally");
        }
    }
}
