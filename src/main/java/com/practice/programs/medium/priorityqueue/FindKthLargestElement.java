package com.practice.programs.medium.priorityqueue;

import java.util.PriorityQueue;

class FindKthLargestElement {

    // Optimal approach, TC: n log k -> for all n elements, adding in heap
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue();  // min heap
        for (int e : nums) {
            if (pq.size() >= k) {
                if (e > pq.peek()) {
                    pq.poll();
                    pq.add(e);
                }
            } else {
                pq.add(e);
            }
        }
        return pq.peek();
    }
}
