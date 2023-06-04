package com.demo.javaconcepts.multithreading.executorservice.types;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class CachedThreadPoolExecutorService {

    /**
     * Creates new thread if no threads are available.
     * After termination of task, thread is kept active for some time and then killed
     */
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        IntStream.range(0, 10)
                .forEach(i -> executorService.submit(() -> {
                    log.info("{} - Thread Id: {}", i, Thread.currentThread().getId());
                }));
        try {
            executorService.awaitTermination(100, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } finally {
            executorService.shutdown();
        }
    }
}
