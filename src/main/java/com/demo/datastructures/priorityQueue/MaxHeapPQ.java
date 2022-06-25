package com.demo.datastructures.priorityQueue;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MaxHeapPQ<T> extends AbstractMaxHeap<T> {

    ArrayList<Element<T>> heap;

    public MaxHeapPQ() {
        this.heap = new ArrayList<>();
    }

    @Override
    public void insert(T data, int priority) {
        heap.add(new Element<>(data, priority));
        int ci = size() - 1;
        int pi = (ci - 1) / 2;

        while (ci >= 0 && pi >= 0 && getPriority(pi) < getPriority(ci)) {
            swap(heap, ci, pi);
            ci = pi;
            pi = (ci - 1) / 2;
        }
    }

    @Override
    public T getMax() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return heap.get(0).data;
    }

    @Override
    public T removeMax() throws NoSuchElementException {
        T max = getMax();

        // Replace top of heap with last element and then remove last element
        heap.set(0, heap.get(size() - 1));
        heap.remove(size() - 1);

        // Re-heap
        int pi = 0;
        int ci1 = 1;
        int ci2 = 2;

        while (true) {
            // Find Idx to swap element
            int si;
            if (ci1 < size() && ci2 < size()) {
                si = getPriority(ci1) > getPriority(ci2) ? ci1 : ci2;
            } else if (ci1 < size() && ci2 >= size()) {
                si = ci1;
            } else {
                break;
            }

            // Swap if need to swap, else break;
            if (getPriority(pi) < getPriority(si)) {
                swap(heap, pi, si);
                pi = si;
            } else {
                break;
            }
            ci1 = pi * 2 + 1;
            ci2 = pi * 2 + 2;
        }

        return max;
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
