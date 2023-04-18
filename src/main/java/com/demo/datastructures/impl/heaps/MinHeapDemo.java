package com.demo.datastructures.impl.heaps;

class MinHeapDemo {

    public static void main(String[] args) {
        MinHeap<String> minHeap = new MinHeap<>(5);
        minHeap.add(10, "Ten");
        minHeap.add(20, "Twenty");
        minHeap.add(30, "Thirty");
        minHeap.add(40, "Forty");
        minHeap.add(50, "Fifty");
        minHeap.add(5, "Five");
        minHeap.add(2, "Two");
        System.out.println(minHeap);
    }
}
