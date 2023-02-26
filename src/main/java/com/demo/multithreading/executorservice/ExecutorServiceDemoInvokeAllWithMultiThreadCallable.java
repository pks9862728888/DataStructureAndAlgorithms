package com.demo.multithreading.executorservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class ExecutorServiceDemoInvokeAllWithMultiThreadCallable {

    public static void main(String[] args) {
        try (ExecutorService executorService = Executors.newFixedThreadPool(4)) {
            List<Callable<Integer>> callableList = new ArrayList<>();
            callableList.add(() -> 1);
            callableList.add(() -> 2);

            Thread.sleep(100);
            List<Future<Integer>> results = executorService.invokeAll(callableList, 10, TimeUnit.MILLISECONDS);
            System.out.println(results);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
