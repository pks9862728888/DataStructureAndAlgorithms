package com.practice.programs.revise.medium.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://www.codingninjas.com/codestudio/problems/majority-element_6783241?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
class MajorityEleMooresVotingAlgorithm {

    /**
     * TC: O(2n), AS: O(1)
     */
    private static int majorityElementOptimalApproachMooresVotingAlgorithm(int[] arr) {
        // Get vote for majority element
        int majorityEle = -1;
        int count = 0;
        for (int e: arr) {
            if (e == majorityEle) {
                count++;
            } else {
                count--;
                if (count <= 0) {
                    majorityEle = e;
                    count = 1;
                }
            }
        }

        // Check if voted ele is majority
        count = 0;
        for (int e: arr) {
            if (e == majorityEle) {
                count++;
            }
        }
        return count > arr.length / 2 ? majorityEle : -1;
    }

    /**
     * TC: O(n), AS: O(n)
     */
    private static int majorityElementBetterApproach(int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int e: arr) {
            freqMap.put(e, freqMap.getOrDefault(e, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry: freqMap.entrySet()) {
            if (entry.getValue() > arr.length / 2) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
