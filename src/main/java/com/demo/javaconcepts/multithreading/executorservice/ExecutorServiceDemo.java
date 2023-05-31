package com.demo.javaconcepts.multithreading.executorservice;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class ExecutorServiceDemo {

    /**
     * We should always close executor service else our program will never terminate
     */
    public static void main(String[] args) {
//        demoWithoutClosingExecutorService();
        demoWithClosingExecutorService();
    }

    private static void demoWithClosingExecutorService() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {
            // Submit method returns a future object as callback
            // Null value indicates successful execution if we pass runnable
            Future<?> result = executorService.submit(() -> log.info("Thread: {} Random value: {}",
                    Thread.currentThread().getId(), Math.random()));
            log.info("Future callback result: {}", result.get());

            // Execute method does not return any object
            executorService.execute(() -> log.info("Thread: {} Random value: {}",
                    Thread.currentThread().getId(), Math.random()));
        } catch (ExecutionException | InterruptedException e) {
            log.error(e.toString());
            System.exit(1);
        } finally {
            executorService.shutdown();
        }
    }

    private static void demoWithoutClosingExecutorService() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> log.info("Thread: {} Random value: {}",
                Thread.currentThread().getId(), Math.random()));
    }
}
