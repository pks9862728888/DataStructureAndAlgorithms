package com.demo.javaconcepts.multithreading.joins;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DemoJoin extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            log.info("Thread: {} id: {}", Thread.currentThread().getId(), i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public static void main(String[] args) {
        DemoJoin dj1 = new DemoJoin();
        DemoJoin dj2 = new DemoJoin();

        dj1.start();

        try {
            // It will wait for 2 seconds for dj1 to complete,
            // If still it doesn't complete then it executes both threads in parallel
            dj1.join(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        dj2.start();
    }
}
