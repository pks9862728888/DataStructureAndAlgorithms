package com.demo.javaconcepts.multithreading.concurrentcollection;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

@Slf4j
public class CopyOnWriteCollectionsDemo {

    public static void main(String[] args) {
        // Everytime list is modified, a new list is generated
        // Bad for performance, but thread safe
        // Use it when traversal outnumber mutation
        // Null values are permitted
        // Iterator remove() operation is not permitted
        List<Integer> l = new CopyOnWriteArrayList<>();
        l.add(1);
        l.add(2);
        l.forEach(i -> {
            log.info("List item: {}", i);
            l.add(99);
        });
        log.info("New list: {}", l);

        // Everytime set is modified, a new set is generated
        // Thread safe
        // Use it when traversal outnumber mutation and set is small
        Set<Object> s = new CopyOnWriteArraySet<>();
        s.add(1);
        s.add(2);
        s.add(null);
        s.forEach(i -> {
            log.info("Set item: {}", i);
            s.add(99);
        });
        log.info("New set: {}", s);
    }
}
