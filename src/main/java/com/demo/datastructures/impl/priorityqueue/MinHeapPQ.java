package com.demo.datastructures.impl.priorityqueue;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MinHeapPQ<T> extends AbstractMinHeap<T> {

    ArrayList<Element<T>> heap;

    public MinHeapPQ() {
        this.heap = new ArrayList<>();
    }

    @Override
    public void add(T data, int priority) {
        heap.add(new Element<>(data, priority));
        int ci = size() - 1;
        int pi = (ci - 1) / 2;

        while (pi >= 0 && ci >= 0 && getPriority(pi) > getPriority(ci)) {
            swap(heap, pi, ci);
            ci = pi;
            pi = (ci - 1) / 2;
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

        // Re-heap
        int pi = 0;
        int ci1 = 1;
        int ci2 = 2;

        while (true) {
            // Find Idx to swap element
            int si;
            if (ci1 < size() && ci2 < size()) {
                si = getPriority(ci1) < getPriority(ci2) ? ci1 : ci2;
            } else if (ci1 < size() && ci2 >= size()) {
                si = ci1;
            } else {
                break;
            }

            // Swap if need to swap, else break;
            if (getPriority(pi) > getPriority(si)) {
                swap(heap, pi, si);
                pi = si;
            } else {
                break;
            }
            ci1 = pi * 2 + 1;
            ci2 = pi * 2 + 2;
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
