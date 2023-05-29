package com.demo.javaconcepts.multithreading.creatingthread.implementingrunnable;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RunnableDemo {

    public static void main(String[] args) {
        Thread thread = new Thread(new ImplementsRunnable());
        log.info("Before running Thread: {} and current state is: {}", thread.getId(), thread.getState());
        thread.start();
        try {
            Thread.sleep(1500);
            log.info("While running Thread: {} and current state is: {}", thread.getId(), thread.getState());
            thread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        log.info("After running Thread: {} and current state is: {}", thread.getId(), thread.getState());
    }
}
