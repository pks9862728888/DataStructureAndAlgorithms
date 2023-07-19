package com.demo.javaconcepts.errors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExceptionInInitializerErrorDemo {

    static int i = 1 / 0;

    static {
        int j = 0;
        if (j == 0) {
            throw new ArithmeticException("Whatever");
        }
    }

    public static void main(String[] args) {
        log.info("Main method");
    }
}
