package com.demo.datastructures.impl.heaps.maxheap;

class MaxHeapDemo {

    public static void main(String[] args) {
        MaxHeap<String> maxHeap = new MaxHeap<>(5);
        maxHeap.add("Ten", 10);
        maxHeap.add("Twenty", 20);
        maxHeap.add("Thirty", 30);
        maxHeap.add("Forty", 40);
        maxHeap.add("Fifty", 50);
        maxHeap.add("Five", 5);
        maxHeap.add("Two", 2);
        System.out.println(maxHeap);
    }
}
