package com.demo.javaconcepts.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FinallyWontExecute {

    public static void main(String[] args) {
//        example1WhenFinallyWontExecute();
        example2WhenFinallyWontExecute();
    }

    private static void example2WhenFinallyWontExecute() {
        try {
            throw new RuntimeException("Runtime exception");
        } catch (Exception e) {
            System.exit(1);
        } finally {
            log.info("Finally wont execute!");
        }
    }

    private static void example1WhenFinallyWontExecute() {
        try {
            System.exit(1);
            throw new RuntimeException("Runtime exception");
        } finally {
            log.info("Finally wont execute!");
        }
    }
}
