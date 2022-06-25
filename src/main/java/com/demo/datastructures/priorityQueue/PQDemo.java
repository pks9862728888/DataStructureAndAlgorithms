package com.demo.datastructures.priorityQueue;

public class PQDemo {

    public static void main(String[] args) {
//        minHeap();
        maxHeap();
    }

    private static void maxHeap() {
        System.out.println("MAX HEAP");
        AbstractMaxHeap<Integer> pq = new MaxHeapPQ<>();
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
        System.out.println("GET MAX: " + pq.getMax());
        System.out.println("REMOVE MAX: " + pq.removeMax());
        pq.print();
    }

    private static void minHeap() {
        System.out.println("MIN HEAP");
        AbstractMinHeap<Integer> pq = new MinHeapPQ<>();
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
