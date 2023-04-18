package com.demo.datastructures.impl.priorityqueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class PQDemo {

    public static void main(String[] args) {
//        minHeap();
//        maxHeap();
        minHeapJava();
        maxHeapJava();
    }

    private static void maxHeapJava() {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(10);
        pq.add(100);
        pq.add(50);
        System.out.println("MAX HEAP PQ JAVA:");
        System.out.print(pq.poll() + " ");
        System.out.print(pq.poll() + " ");
        System.out.println(pq.poll());
    }

    private static void minHeapJava() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(100);
        pq.add(50);
        System.out.println("MIN HEAP PQ JAVA:");
        System.out.print(pq.poll() + " ");
        System.out.print(pq.poll() + " ");
        System.out.println(pq.poll());
    }

    private static void maxHeap() {
        System.out.println("MAX HEAP");
        AbstractMaxHeap<Integer> pq = new MaxHeapPQ<>();
        pq.add(10, 10);
        pq.add(20, 20);
        pq.add(40, 40);
        pq.add(60, 60);
        pq.add(100, 100);
        pq.add(45, 45);
        pq.add(50, 50);
        pq.add(80, 80);
        pq.add(15, 15);

        pq.print();
        System.out.println("GET MAX: " + pq.getMax());
        System.out.println("REMOVE MAX: " + pq.removeMax());
        pq.print();
    }

    private static void minHeap() {
        System.out.println("MIN HEAP");
        AbstractMinHeap<Integer> pq = new MinHeapPQ<>();
        pq.add(10, 10);
        pq.add(20, 20);
        pq.add(40, 40);
        pq.add(60, 60);
        pq.add(100, 100);
        pq.add(45, 45);
        pq.add(50, 50);
        pq.add(80, 80);
        pq.add(15, 15);

        pq.print();
        System.out.println("GET MIN: " + pq.getMin());
        System.out.println("REMOVE MIN: " + pq.removeMin());
        pq.print();
    }
}
