package com.demo.javaconcepts.multithreading.concurrentcollection;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

@Slf4j
public class ConcurrentCollectionDemo {

    public static final int ITERATION = 100000;

    /**
     * ConcurrentHashMap is more performant than SynchronizedMap
     */
    public static void main(String[] args) {
        evaluatePerformance(new HashMap<>());
        evaluatePerformance(Collections.synchronizedMap(new HashMap<>()));
        evaluatePerformance(new ConcurrentHashMap<>());
    }

    private static void evaluatePerformance(Map<Integer, Integer> map) {
        ExecutorService es = Executors.newFixedThreadPool(500);
        try {
            Stopwatch stopwatch = Stopwatch.createStarted();
            List<Future<Integer>> callback = new ArrayList<>();
            IntStream.range(0, ITERATION)
                    .parallel()
                    .forEach(i -> callback.add(es.submit(() -> map.put(i, i))));
            for (Future<Integer> future : callback) {
                future.get();
            }
            stopwatch.stop();
            log.info("{} - took: {} - size: {}", map.getClass().getSimpleName(), stopwatch.elapsed(), map.size());
        } catch (Exception e) {
            log.error(e.toString());
        } finally {
            es.shutdown();
        }
    }
}
