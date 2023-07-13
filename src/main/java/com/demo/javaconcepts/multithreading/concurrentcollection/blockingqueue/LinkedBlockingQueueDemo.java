package com.demo.javaconcepts.multithreading.concurrentcollection.blockingqueue;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

@Slf4j
public class LinkedBlockingQueueDemo {

    public static void main(String[] args) {
        // Allows creation of thread safe queue of specified size
        // Does not allow null values
        BlockingQueue<Integer> q = new LinkedBlockingQueue<>(1);
        // If empty peek and poll will return null
        log.info("peek: {}", q.peek());
        log.info("poll: {}", q.poll());

        q.offer(10);  // Returns true if element can be added, current size < capacity
        log.info("Queue: {}", q);

        // Special methods of blocking queue
        try {
            log.info("offer: {}", q.offer(11, 1, TimeUnit.MILLISECONDS));
            log.info("poll: {}", q.poll(1, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
