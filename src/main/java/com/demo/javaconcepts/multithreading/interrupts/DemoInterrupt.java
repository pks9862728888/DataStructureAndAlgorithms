package com.demo.javaconcepts.multithreading.interrupts;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DemoInterrupt {

    public static void main(String[] args) {
        Thread obj = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    log.info(String.valueOf(i));
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    log.info(Thread.currentThread().getState() + " " + Thread.currentThread().isInterrupted());
                    Thread.currentThread().interrupt();
                    log.info(Thread.currentThread().getState() + " " + Thread.currentThread().isInterrupted());
                    break;
                }
            }
        });
        obj.start();
        // Calling interrupt on a running thread throws interrupted exception
        obj.interrupt();
        // Calling interrupt on a dead thread does nothing, it sets isInterrupted flag to true
        obj.interrupt();
        obj.interrupt();
        obj.interrupt();
        obj.interrupt();
    }
}
