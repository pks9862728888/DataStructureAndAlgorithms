package com.demo.datastructures.priorityQueue;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MinHeapPQ<T> implements PQ<T> {

    ArrayList<Element<T>> heap;

    public MinHeapPQ() {
        this.heap = new ArrayList<>();
    }

    @Override
    public void insert(T data, int priority) {
        heap.add(new Element<>(data, priority));
        int childIdx = size() - 1;
        int parentIdx = (childIdx - 1) / 2;

        while (parentIdx > 0 && childIdx > 0 && heap.get(parentIdx).priority > heap.get(childIdx).priority) {
            swap(heap, parentIdx, childIdx);
            childIdx = parentIdx;
            parentIdx = (childIdx - 1) / 2;
        }
    }

    @Override
    public T getMin() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return heap.get(0).data;
    }

    @Override
    public T removeMin() throws NoSuchElementException {
        T min = getMin();

        // Replace top of heap with last element and then remove last element
        heap.set(0, heap.get(size() - 1));
        heap.remove(size() - 1);
        int parentIdx = 0;
        int childIdx1 = 1;
        int childIdx2 = 2;

        while (true) {
            // Find Idx to swap element
            int swapIdx;
            if (childIdx1 < size() && childIdx2 < size()) {
                swapIdx = getPriority(childIdx1) < getPriority(childIdx2) ? childIdx1 : childIdx2;
            } else if (childIdx1 < size() && childIdx2 >= size()) {
                swapIdx = childIdx1;
            } else {
                break;
            }

            // Swap if need to swap, else break;
            if (getPriority(parentIdx) > getPriority(swapIdx)) {
                swap(heap, parentIdx, swapIdx);
                parentIdx = swapIdx;
            } else {
                break;
            }
            childIdx1 = parentIdx * 2 + 1;
            childIdx2 = parentIdx * 2 + 2;
        }

        return min;
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public void print() {
        System.out.println(heap);
    }

    private int getPriority(int idx) {
        return heap.get(idx).priority;
    }
}
