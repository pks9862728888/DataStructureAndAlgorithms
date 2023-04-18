package com.demo.datastructures.impl.heaps.maxheap;

import com.demo.datastructures.impl.heaps.HeapNode;

import java.util.Arrays;

public class MaxHeap<T> {

    private HeapNode<T>[] heap;
    private int capacity;
    private int size;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = (HeapNode<T>[]) new HeapNode[capacity];
    }

    public void add(T ele, int priority) {
        if (size() == capacity) {
            doubleCapacity();
        }

        // Add element to last of the heap
        HeapNode<T> heapNode = new HeapNode<>(ele, priority);
        heap[size++] = heapNode;

        // Do heapify operation
        if (size() > 1) {
            int currIdx = size() - 1;
            int parentIdx = getParentIdx(currIdx);
            while (currIdx > 0 && heap[currIdx].getPriority() > heap[parentIdx].getPriority()) {
                swapHeapNodes(currIdx, parentIdx);
                currIdx = parentIdx;
                parentIdx = getParentIdx(currIdx);
            }
        }
    }

    private void swapHeapNodes(int currIdx, int parentIdx) {
        HeapNode<T> temp = heap[currIdx];
        heap[currIdx] = heap[parentIdx];
        heap[parentIdx] = temp;
    }

    public int getParentIdx(int currIdx) {
        return Math.floorDiv(currIdx - 1, 2);
    }

    public int getLeftChildIdx(int currIdx) {
        return 2 * currIdx + 1;
    }

    public int getRightChildIdx(int currIdx) {
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
