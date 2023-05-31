package com.demo.javaconcepts.multithreading.executorservice;

import ch.qos.logback.core.testUtil.RandomUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class ExecutorServiceDemoWithSingleCallable {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {
            Future<Integer> resultFromCallable = executorService
                    .submit(ExecutorServiceDemoWithSingleCallable::getRandomInteger);
            log.info("{}", resultFromCallable.get(10, TimeUnit.MILLISECONDS));
        } catch (ExecutionException | TimeoutException | InterruptedException e) {
            log.error("{}", e.toString());
            System.exit(1);
        } finally {
            executorService.shutdown();
        }
    }

    private static Integer getRandomInteger() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            log.error("{}", e.toString());
        }
        return RandomUtil.getPositiveInt();
    }
}
