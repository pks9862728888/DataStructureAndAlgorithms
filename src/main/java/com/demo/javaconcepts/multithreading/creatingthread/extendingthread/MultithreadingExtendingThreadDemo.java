package com.demo.javaconcepts.multithreading.creatingthread.extendingthread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MultithreadingExtendingThreadDemo {

    public static void main(String[] args) {
        ExtendsThread thread = new ExtendsThread();
        log.info("Before running Thread: {} and current state is: {}", thread.getId(), thread.getState());
        // We should call start() method instead of run() method, because run method does not start the thread
//        thread.run();
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
