package com.demo.multithreading.executorservice;

import java.util.concurrent.*;

public class ExecutorServiceDemoWithSingleCallable {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {
            Future<Integer> resultFromCallable = executorService.submit(() -> 1);
            System.out.println(resultFromCallable.get(1, TimeUnit.MILLISECONDS));
        } catch (ExecutionException | TimeoutException | InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();
        }
    }
}
