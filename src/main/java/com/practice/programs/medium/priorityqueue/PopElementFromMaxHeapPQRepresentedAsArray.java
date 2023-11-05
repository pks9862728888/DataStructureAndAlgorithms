package com.practice.programs.medium.priorityqueue;

import java.util.List;

/**
 * TC: O(h), AS: O(1)
 * <a href="https://www.codingninjas.com/studio/problems/implement-a-priority-queue-_1743878?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Problem</a>
 */
class PopElementFromMaxHeapPQRepresentedAsArray {

    public static int pop(List<Integer> heap) {
        if (heap.isEmpty()) {
            return -1;
        }

        // Get max element
        int max = heap.get(0);

        // Swap with largest child element
        int last = heap.get(heap.size() - 1);
        heap.remove(heap.size() - 1);

        // Call heapify
        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapify(heap);
        }
        return max;
    }

    private static void heapify(List<Integer> heap) {
        int parentIdx = 0;
        while (parentIdx < heap.size()) {
            int maxIdx = parentIdx;
            int rightChildIdx = getRightChildIdx(parentIdx);
            if (rightChildIdx < heap.size() &&
                    heap.get(rightChildIdx) > heap.get(maxIdx)) {
                maxIdx = rightChildIdx;
            }
            int leftChildIdx = getLeftChildIdx(parentIdx);
            if (leftChildIdx < heap.size() &&
                    heap.get(leftChildIdx) > heap.get(maxIdx)) {
                maxIdx = leftChildIdx;
            }
            if (maxIdx == parentIdx) {
                return;
            } else {
                swap(parentIdx, maxIdx, heap);
                parentIdx = maxIdx;
            }
        }
    }

    private static void swap(int idx1, int idx2, List<Integer> heap) {
        int temp = heap.get(idx1);
        heap.set(idx1, heap.get(idx2));
        heap.set(idx2, temp);
    }

    private static int getLeftChildIdx(int parentIdx) {
        return 2 * parentIdx + 1;
    }

    private static int getRightChildIdx(int parentIdx) {
        return 2 * parentIdx + 2;
    }

}
