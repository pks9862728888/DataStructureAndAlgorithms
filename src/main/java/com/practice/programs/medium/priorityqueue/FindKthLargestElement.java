package com.practice.programs.medium.priorityqueue;

import java.util.PriorityQueue;

class FindKthLargestElement {

    // Optimal approach, TC: n log k -> for all n elements, adding in heap
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int ele: nums) {
            pq.add(ele);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }
}
