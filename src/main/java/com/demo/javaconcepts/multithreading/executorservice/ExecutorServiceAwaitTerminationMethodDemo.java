package com.demo.javaconcepts.multithreading.executorservice;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class ExecutorServiceAwaitTerminationMethodDemo {

    public static void main(String[] args) {
        demoAwaitTermination();
    }

    private static void demoAwaitTermination() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {
            Future<?> result1 = executorService.submit(ExecutorServiceAwaitTerminationMethodDemo::getRandomInteger);
            executorService.shutdown();
            log.info("awaitTermination result: {} since running task was not shutdown in specified ms",
                    executorService.awaitTermination(10, TimeUnit.MILLISECONDS));

            // Since executor was shutdown, it will not accept any new tasks, it will throw exception
            try {
                Future<Integer> result2 = executorService
                        .submit(ExecutorServiceAwaitTerminationMethodDemo::getRandomInteger);
                log.info("Task2 result: {}", result2.get());
            } catch (RejectedExecutionException e) {
                log.error("Since executor was shutdown, so it throws exception: {}", e.toString());
            }

            // Though shutdown was called, but executor will wait for existing task to get completed
            log.info("Future callback result1: {}", result1.get());
        } catch (ExecutionException | InterruptedException e) {
            log.error(e.toString());
            System.exit(1);
        } finally {
            executorService.shutdown();
        }
    }

    private static Integer getRandomInteger() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("{}", e.toString());
        }
        return ThreadLocalRandom.current().nextInt(0, Integer.MAX_VALUE);
    }
}
