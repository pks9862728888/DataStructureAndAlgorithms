package com.practice.programs.revise.medium.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 * TC: O(n log K), AS: O(n)
 * Concepts:
 * HEAP
 * MIN_HEAP
 */
public class KMostFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = findFreq(nums);
        PriorityQueue<int[]> minHeap = findKMostFrequentElements(k, freqMap);
        return convertToResultArray(k, minHeap);
    }

    private static int[] convertToResultArray(int k, PriorityQueue<int[]> minHeap) {
        int[] res = new int[k];
        for (int j = k - 1; j >= 0; j--) {
            res[j] = minHeap.poll()[0];
        }
        return res;
    }

    private static PriorityQueue<int[]> findKMostFrequentElements(int k, Map<Integer, Integer> freqMap) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (Map.Entry<Integer, Integer> entry: freqMap.entrySet()) {
            minHeap.add(new int[]{entry.getKey(), entry.getValue()});
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap;
    }

    private static Map<Integer, Integer> findFreq(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int n: nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }
        return freqMap;
    }
}
