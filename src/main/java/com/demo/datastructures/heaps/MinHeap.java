package com.demo.datastructures.heaps;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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

    public int leftChild(int currIdx) {
        return 2 * currIdx + 1;
    }

    public int rightChild(int currIdx) {
        return 2 * currIdx + 2;
    }

    public int parentIdx(int currIdx) {
        return (int) Math.floor((currIdx - 1) * 1.0 / 2);
    }

    public void add(int priority, T value) {
        HeapNode<T> heapNode = new HeapNode<>(priority, value);
        if (size == capacity) {
            doubleCapacity();
        }

        // Add to last of heap
        heap[size++] = heapNode;

        // Move the node to correct position based on priority
        int currIdx = size - 1;
        int parentIdx = parentIdx(currIdx);
        while (parentIdx >= 0 && heap[parentIdx].getPriority() > heap[currIdx].getPriority()) {
            swapNodes(currIdx, parentIdx);
            currIdx = parentIdx;
            parentIdx = parentIdx(currIdx);
        }
    }

    private void swapNodes(int currIdx, int parentIdx) {
        HeapNode<T> temp = heap[currIdx];
        heap[currIdx] = heap[parentIdx];
        heap[parentIdx] = temp;
    }

    private void doubleCapacity() {
        int maxCapacity = 2 * capacity;
        heap = Arrays.copyOf(heap, maxCapacity);
        capacity = maxCapacity;
    }

    @Override
    public String toString() {
        return Arrays.toString(heap);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @ToString
    public static class HeapNode<T> {
        private int priority;
        private T value;
    }
}
