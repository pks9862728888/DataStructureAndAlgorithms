package com.demo.javaconcepts.inheritance.overriding;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OverridingStaticMethodDemo extends CantOverrideStaticMethodsInJava {

    // Overriding is not allowed here
    // @Override
    static void method() {
        log.info("In child class...");
    }

    public static void main(String[] args) {
        OverridingStaticMethodDemo.method();
    }

}
