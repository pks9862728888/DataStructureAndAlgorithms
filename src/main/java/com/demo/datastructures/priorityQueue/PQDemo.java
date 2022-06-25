package com.demo.datastructures.priorityQueue;

public class PQDemo {

    public static void main(String[] args) {
        minHeap();
    }

    private static void minHeap() {
        System.out.println("MIN HEAP");
        PQ<Integer> pq = new MinHeapPQ<>();
        pq.insert(10, 10);
        pq.insert(20, 20);
        pq.insert(40, 40);
        pq.insert(60, 60);
        pq.insert(100, 100);
        pq.insert(45, 45);
        pq.insert(50, 50);
        pq.insert(80, 80);
        pq.insert(15, 15);

        pq.print();
        System.out.println("GET MIN: " + pq.getMin());
        System.out.println("REMOVE MIN: " + pq.removeMin());
        pq.print();
    }
}
