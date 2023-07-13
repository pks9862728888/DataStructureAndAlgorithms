package com.demo.javaconcepts.multithreading.problems;

import com.utils.DateTimeUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DeadlockDemo {

    private static final Object one = new Object();
    private static final Object two = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
           synchronized (one) {
               log.info("Thread 1 has lock on object 1");
               DateTimeUtils.sleepSec(1);
               synchronized (two) {
                   log.info("Thread 1 has lock on object 2");
               }
           }
        });
        Thread t2 = new Thread(() -> {
            synchronized (two) {
                log.info("Thread 2 has lock on object 2");
                DateTimeUtils.sleepSec(1);
                synchronized (one) {
                    log.info("Thread 2 has lock on object 1");
                }
            }
        });
        t1.start();
        t2.start();
    }
}
