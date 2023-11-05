package com.practice.programs.medium.priorityqueue;

import java.util.ArrayList;
import java.util.List;

/**
 * TC insert: O(log n), extract min: O(log n)
 * <a href="https://www.codingninjas.com/studio/problems/min-heap-implementation_5480527?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
class MinHeap {

    private final List<Integer> heap;

    MinHeap(int size) {
        this.heap = new ArrayList<>(size);
    }

    int extractMinElement() {
        if (heap.isEmpty()) {
            return -1;
        }
        int min = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        deleteElement(heap.size() - 1);
        heapify(0);
        return min;
    }

    void deleteElement(int idx) {
        if (idx < heap.size()) {
            heap.remove(idx);
        }
    }

    void insert(int val) {
        heap.add(val);
        int currIdx = heap.size() - 1;
        while (currIdx > 0) {
            int parentIdx = getParentIdx(currIdx);
            if (parentIdx >= 0 && val < heap.get(parentIdx)) {
                swap(currIdx, parentIdx);
                currIdx = parentIdx;
            } else {
                break;
            }
        }
    }

    private void heapify(int parentIdx) {
        if (heap.isEmpty()) {
            return;
        }
        while (parentIdx < heap.size()) {
            int minIdx = parentIdx;

            // Check left child
            int leftIdx = getLeftChildIdx(parentIdx);
            if (leftIdx < heap.size() && heap.get(leftIdx) < heap.get(minIdx)) {
                minIdx = leftIdx;
            }

            // Check right child
            int rightIdx = getRightChildIdx(parentIdx);
            if (rightIdx < heap.size() && heap.get(rightIdx) < heap.get(minIdx)) {
                minIdx = rightIdx;
            }

            // Swap and update parent
            if (parentIdx != minIdx) {
                swap(parentIdx, minIdx);
                parentIdx = minIdx;
            } else {
                break;
            }
        }
    }

    private int getParentIdx(int currIdx) {
        return (currIdx - 1) / 2;
    }

    private int getLeftChildIdx(int parentIdx) {
        return parentIdx * 2 + 1;
    }

    private int getRightChildIdx(int parentIdx) {
        return parentIdx * 2 + 2;
    }

    private void swap(int idx1, int idx2) {
        int temp = heap.get(idx1);
        heap.set(idx1, heap.get(idx2));
        heap.set(idx2, temp);
    }

}
