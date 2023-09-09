package com.practice.programs.easy.twopointer;

import java.util.HashMap;
import java.util.Map;

/**
 * TC: O(n), AS: O(n)
 * Approach: Hashing
 */
public class FindIfPairExistsWithGivenSumInUnSortedArray {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> elementMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (elementMap.containsKey(target - nums[i])) {
                return new int[]{elementMap.get(target - nums[i]), i};
            }
            elementMap.put(nums[i], i);
        }
        return new int[0];
    }
}
