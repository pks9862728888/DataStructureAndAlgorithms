package com.demo.datastructures.impl.heaps.minheap;

import com.demo.datastructures.impl.heaps.HeapNode;

import java.util.Arrays;

class MinHeap<T> {

    private int capacity;
    private int size;
    private HeapNode<T>[] heap;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = (HeapNode<T>[]) new HeapNode[capacity];
    }

    public void add(int priority, T value) {
        if (size() == capacity) {
            doubleCapacity();
        }

        // Add to last of heap
        HeapNode<T> heapNode = new HeapNode<>(value, priority);
        heap[size++] = heapNode;

        // Heapify: Move the node to correct position based on priority
        if (size() > 1) {
            int currIdx = size() - 1;
            int parentIdx = parentIdx(currIdx);
            while (currIdx > 0 && heap[parentIdx].getPriority() > heap[currIdx].getPriority()) {
                swapNodes(currIdx, parentIdx);
                currIdx = parentIdx;
                parentIdx = parentIdx(currIdx);
            }
        }
    }

    private void swapNodes(int currIdx, int parentIdx) {
        HeapNode<T> temp = heap[currIdx];
        heap[currIdx] = heap[parentIdx];
        heap[parentIdx] = temp;
    }

    public int parentIdx(int currIdx) {
        return Math.floorDiv(currIdx - 1, 2);
    }

    public int leftChildIdx(int currIdx) {
        return 2 * currIdx + 1;
    }

    public int rightChildIdx(int currIdx) {
        return 2 * currIdx + 2;
    }

    private void doubleCapacity() {
        int maxCapacity = 2 * capacity;
        heap = Arrays.copyOf(heap, maxCapacity);
        capacity = maxCapacity;
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        return Arrays.toString(heap);
    }
}
