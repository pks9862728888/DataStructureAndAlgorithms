package com.demo.multithreading.executorservice;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {

    /**
     * We should always close executor service else our program will never terminate
     */
    public static void main(String[] args) {
//        demoWithoutClosingExecutorService();
        demoWithClosingExecutorService();
    }

    private static void demoWithClosingExecutorService() {
        try (ExecutorService executorService = Executors.newSingleThreadExecutor()) {
            executorService.submit(() -> System.out.printf("Thread: %s Random value: %s%n",
                    Thread.currentThread().threadId(), Math.random()));
        }
    }

    private static void demoWithoutClosingExecutorService() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> System.out.printf("Thread: %s Random value: %s%n",
                Thread.currentThread().threadId(), Math.random()));
    }
}
