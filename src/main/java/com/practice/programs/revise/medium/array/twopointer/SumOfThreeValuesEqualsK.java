package com.practice.programs.revise.medium.array.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/3sum/description/
 * TC: O (n * 2 + n log n) = O(n*2), AS: O(1)
 * Concept:
 * ARRAY
 * THREE_SUM_PROBLEM
 * TWO_POINTER
 * FIRST_LEFT_POINTER_N_PLACE_MID_TO_NEXT_N_RIGHT_TO_EXTREME_RIGHT_APPROACH
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
     * AS: O(1) not considering ans
     * Concepts:
     * TWO_POINTER
     * TWO_POINTER_START_N_END_OF_ARRAY
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // skip duplicates for i
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    triplets.add(List.of(nums[i], nums[left], nums[right]));
                    while(left < right && nums[left] == nums[left + 1]) left++; // remove left duplicate
                    while(left < right && nums[right] == nums[right - 1]) right--; // remove right duplicate
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return triplets;
    }
}
