package com.demo.javaconcepts.multithreading.executorservice.types;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ScheduledExecutorServiceFixedRate {

    /**
     * Difference between scheduleAtFixedRate and scheduleAtFixedDelay is:
     * scheduleAtFixedDelay - guarantees that there will be a fixed delay between end and start of next task
     * scheduleAtFixedRate - does not guarantee that there will be a fixed delay between end and start of next task
     * It keeps on triggering at a fixed rate from the start of the task
     */
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(50);
        ScheduledFuture<?> scheduledFuture = executorService.scheduleAtFixedRate(() -> log.info("{}",
                Thread.currentThread().getId()), 100, 500, TimeUnit.MILLISECONDS);
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } finally {
            executorService.shutdown();
        }
    }
}
