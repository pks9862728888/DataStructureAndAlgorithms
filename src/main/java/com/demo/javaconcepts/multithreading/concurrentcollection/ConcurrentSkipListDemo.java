package com.demo.javaconcepts.multithreading.concurrentcollection;

import lombok.extern.slf4j.Slf4j;

import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

@Slf4j
public class ConcurrentSkipListDemo {

    public static void main(String[] args) {
        // Conceptually: Thread safe TreeSet
        // Elements are stored in natural ordering
        Set<Integer> set = new ConcurrentSkipListSet<>();
        set.add(4);
        set.add(1);
        set.forEach(i -> log.info("Set item: {}", i));

        // Conceptually: Thread safe TreeMap
        // Elements are stored in natural ordering
        // Does not allow null key as well as null value
        ConcurrentMap<Integer, Integer> cm = new ConcurrentSkipListMap<>();
        cm.put(4, 4);
        cm.put(1, 1);
//        cm.put(2, null);
        cm.forEach((k, v) -> log.info("key: {} value: {}", k, v));
    }
}
