package com.demo.javaconcepts.inheritance.overriding;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CantOverrideStaticMethodsInJava {

    static void method() {
        log.info("In parent class...");
    }
}
