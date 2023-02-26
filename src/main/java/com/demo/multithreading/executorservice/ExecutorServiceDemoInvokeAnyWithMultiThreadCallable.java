package com.demo.multithreading.executorservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceDemoInvokeAnyWithMultiThreadCallable {

    public static void main(String[] args) {
        try (ExecutorService executorService = Executors.newFixedThreadPool(4)) {
            List<Callable<Integer>> callableList = new ArrayList<>();
            callableList.add(() -> 1);
            callableList.add(() -> 2);

            Thread.sleep(100);
            Integer result = executorService.invokeAny(callableList, 10, TimeUnit.MILLISECONDS);
            System.out.println(result);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
