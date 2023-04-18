package com.demo.datastructures.java.heap;

import java.util.PriorityQueue;

public class MinHeapDemo {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(9);
        pq.add(7);
        pq.add(2);
        pq.add(10);

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
