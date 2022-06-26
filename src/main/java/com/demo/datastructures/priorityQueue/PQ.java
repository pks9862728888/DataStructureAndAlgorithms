package com.demo.datastructures.priorityQueue;

import java.util.ArrayList;

public interface PQ<T> {

    void add(T data, int priority);

    int size();

    boolean isEmpty();

    void print();

    default void swap(ArrayList<Element<T>> heap, int parentIdx, int swapIdx) {
        Element<T> temp = heap.get(parentIdx);
        heap.set(parentIdx, heap.get(swapIdx));
        heap.set(swapIdx, temp);
    }

    class Element<T> {
        T data;
        int priority;

        public Element(T data, int priority) {
            this.data = data;
            this.priority = priority;
        }

        @Override
        public String toString() {
            return "{" + data +
                    ", p=" + priority +
                    '}';
        }
    }
}
