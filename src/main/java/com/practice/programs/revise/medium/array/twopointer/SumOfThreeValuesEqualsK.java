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

    /**
     * https://leetcode.com/problems/3sum/
     * TC: O(n log n + n ^ 2) = O(n^2)
     * AS: O(1) not considering ans
     * Concepts:
     * TWO_POINTER
     * TWO_POINTER_START_N_END_OF_ARRAY
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            // if current element is > 0 we cant have triplet = 0
            if (nums[i] > 0) break;
            int st = i + 1;
            int end = n - 1;
            while (st < end) {
                int sum = nums[i] + nums[st] + nums[end];
                if (sum == 0) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[st]);
                    triplet.add(nums[end]);
                    // skip duplicate value of b
                    do st++;
                    while (st < n && nums[st] == nums[st - 1]);
                } else if (sum > 0) {
                    end--;
                } else {
                    st++;
                }
            }
            // skip duplicate a
            do i++;
            while (i < n && nums[i] == nums[i - 1]);
        }
        return result;
    }
}
