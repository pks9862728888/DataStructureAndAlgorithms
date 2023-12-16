package com.practice.programs.medium.arrays;

import java.util.Arrays;

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
}
