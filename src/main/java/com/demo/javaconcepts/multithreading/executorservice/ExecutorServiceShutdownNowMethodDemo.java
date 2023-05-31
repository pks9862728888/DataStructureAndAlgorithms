package com.demo.javaconcepts.multithreading.executorservice;

import ch.qos.logback.core.testUtil.RandomUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.*;

@Slf4j
public class ExecutorServiceShutdownNowMethodDemo {

    public static void main(String[] args) {
        demoAwaitTermination();
    }

    private static void demoAwaitTermination() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {
            Future<Optional<Integer>> result1 = executorService.submit(
                    ExecutorServiceShutdownNowMethodDemo::getRandomInteger);
            executorService.submit(ExecutorServiceShutdownNowMethodDemo::getRandomInteger);
            List<Runnable> awaitingRunnable = executorService.shutdownNow();
            log.info("Awaiting runnable of size: {} returned on shutdownNow: {}", awaitingRunnable.size(),
                    awaitingRunnable);
            log.info("isShutdown(): {}", executorService.isShutdown());
            log.info("isTerminated(): {}", executorService.isTerminated());

            // Since executor was shutdown, it will not accept any new tasks, it will throw exception
            try {
                executorService
                        .submit(ExecutorServiceShutdownNowMethodDemo::getRandomInteger);
            } catch (RejectedExecutionException e) {
                log.error("Since executor was shutdown, so it throws exception: {}", e.toString());
            }

            // Since shutdownNow() was called, but executor will not wait for existing task to get completed
            log.info("Future callback result1: {}", result1.get());
        } catch (Exception e) {
            log.error(e.toString());
            System.exit(1);
        } finally {
            executorService.shutdown();
        }
    }

    private static Optional<Integer> getRandomInteger() {
        try {
            Thread.sleep(1000);
            return Optional.of(RandomUtil.getPositiveInt());
        } catch (InterruptedException e) {
            log.error("{}", e.toString());
            Thread.currentThread().interrupt();
        }
        return Optional.empty();
    }
}
