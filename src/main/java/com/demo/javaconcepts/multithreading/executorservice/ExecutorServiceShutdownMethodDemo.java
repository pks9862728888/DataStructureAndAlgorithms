package com.demo.javaconcepts.multithreading.executorservice;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.concurrent.*;

@Slf4j
public class ExecutorServiceShutdownMethodDemo {

    public static void main(String[] args) {
        demoWithClosingExecutorService();
    }

    private static void demoWithClosingExecutorService() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {
            Future<Optional<Integer>> result1 = executorService.submit(
                    ExecutorServiceShutdownMethodDemo::getRandomInteger);
            executorService.shutdown();
            log.info("isShutdown(): {}", executorService.isShutdown());
            log.info("isTerminated(): {}", executorService.isTerminated());

            // Since executor was shutdown, it will not accept any new tasks, it will throw exception
            try {
                executorService.submit(ExecutorServiceShutdownMethodDemo::getRandomInteger);
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

    private static Optional<Integer> getRandomInteger() {
        try {
            Thread.sleep(10);
            return Optional.of(ThreadLocalRandom.current().nextInt());
        } catch (InterruptedException e) {
            log.error("{}", e.toString());
            Thread.currentThread().interrupt();
        }
        return Optional.empty();
    }
}
