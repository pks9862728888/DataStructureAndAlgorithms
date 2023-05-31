package com.demo.javaconcepts.multithreading.executorservice;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.*;

@Slf4j
public class ExecutorServiceDemoInvokeAllWithMultiThreadCallable {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        try {
            List<Callable<Optional<String>>> callableList = new ArrayList<>();
            callableList.add(() -> getRandomIntegerString("A"));
            callableList.add(() -> getRandomIntegerString("B"));

            List<Future<Optional<String>>> results = executorService.invokeAll(callableList);
            log.info(results.toString());  // Some tasks might not be completed because we did not call get on Future
        } catch (InterruptedException e) {
            log.error(e.toString());
            System.exit(1);
        } finally {
            executorService.shutdown();
        }
    }

    private static Optional<String> getRandomIntegerString(String taskOrder) {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(0, 10));
            return Optional.of(taskOrder + "-" + ThreadLocalRandom.current().nextInt(0, 10));
        } catch (InterruptedException e) {
            log.error("{}", e.toString());
            Thread.currentThread().interrupt();
        }
        return Optional.empty();
    }
}
