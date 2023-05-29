package com.demo.javaconcepts.multithreading.creatingthread.extendingthread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExtendsThread extends Thread {

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        log.info("Running Thread: {} and current state is: {}", thread.getId(), thread.getState());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        log.info("Running Thread: {} sleep complete and current state is: {}",
                thread.getId(), thread.getState());
    }
}
