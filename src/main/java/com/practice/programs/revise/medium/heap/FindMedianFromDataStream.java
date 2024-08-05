package com.practice.programs.revise.medium.heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/find-median-from-data-stream/
 * TC: log N
 * AS: O(n)
 * Concepts:
 * HEAP
 * MIN_HEAP
 * MAX_HEAP
 */
public class FindMedianFromDataStream {

    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public FindMedianFromDataStream() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.add(num);
            if (Math.abs(maxHeap.size() - minHeap.size()) > 1) {
                minHeap.add(maxHeap.poll());
            }
        } else {
            minHeap.add(num);
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
        }
    }

    public double findMedian() {
        int size = minHeap.size() + maxHeap.size();
        if (size % 2 == 0) {
            return (maxHeap.peek() + minHeap.peek()) * 1.0 / 2;
        } else {
            return maxHeap.peek();
        }
    }
}
