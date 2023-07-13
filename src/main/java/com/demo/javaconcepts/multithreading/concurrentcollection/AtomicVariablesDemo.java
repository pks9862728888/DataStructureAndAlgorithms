package com.demo.javaconcepts.multithreading.concurrentcollection;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class AtomicVariablesDemo {

    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger();
        ai.set(1);
        ai.compareAndSet(1, 2);
        log.info("compareAndSet match expectedValue: {}", ai.get());
        ai.compareAndSet(99, 22);  // does not get set
        log.info("compareAndSet mismatch expectedValue: {}", ai.get());
    }
}
