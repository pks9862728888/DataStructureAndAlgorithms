package com.demo.javaconcepts.inheritance;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProtectedClass {

    protected int data = 1;

    protected void accessProtectedMethodWithoutInheritance() {
        log.info("Doing something...");
    }
}
