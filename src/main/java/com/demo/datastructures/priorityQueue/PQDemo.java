package com.demo.datastructures.priorityQueue;

public class PQDemo {

    public static void main(String[] args) {
        minHeap();
//        maxHeap();
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
