package com.demo.javaconcepts.errors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NoClassDefFoundError {

    public static void main(String[] args) {
        try {
            new Demo();     // ExceptionInInitializerError
        } catch (Error e) {
            log.error(e.toString());
        }
        new Demo();  // NoClassDefFoundError
    }

    private static class Demo {
        static int i = 5 / 0;
    }
}
