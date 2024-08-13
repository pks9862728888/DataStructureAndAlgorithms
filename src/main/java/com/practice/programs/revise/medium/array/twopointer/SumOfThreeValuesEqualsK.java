package com.practice.programs.revise.medium.array.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * TC: O (n * 2 + n log n) = O(n*2), AS: O(1)
 */
public class SumOfThreeValuesEqualsK {

    public static boolean findSumOfThree(int[] nums, int target) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum == target) {
                    return true;
                } else if (sum < target) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return false;
    }

    /**
     * https://leetcode.com/problems/3sum/
     * TC: O(n log n + n ^ 2) = O(n^2)
     * AS: O(noOfDistinctCombinations)
     * Concepts:
     * TWO_POINTER
     * TWO_POINTER_START_N_END_OF_ARRAY
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<String> cache = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            int low = i + 1;
            int high = n - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum == 0) {
                    String key = nums[i] + "#" + nums[low] + "#" + nums[high];
                    if (cache.add(key)) {
                        res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    }
                    low++;
                } else if (sum < 0) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return res;
    }
}
