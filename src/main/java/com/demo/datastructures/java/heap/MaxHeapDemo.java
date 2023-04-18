package com.demo.datastructures.java.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxHeapDemo {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(9);
        pq.add(7);
        pq.add(2);
        pq.add(10);

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
