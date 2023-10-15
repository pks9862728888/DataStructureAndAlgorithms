package com.practice.programs.revise.algorithms.sorting.arrays;

import java.util.List;

/**
 * TC: O(n), AS: O(1)
 * Sorts in wave like fashion, i.e. nums[0] <= nums[1] >= nums[2] <= nums[3]
 */
class WiggleSort {

    // 1 5 1 1 1 6 4 -> 1 5 1 1 1 6 4

    static List<Integer> wiggleSort(int n, List<Integer>nums) {
        for (int i = 1; i < n; i += 2) {
            if (nums.get(i) < nums.get(i - 1)) {
                swap(nums, i, i - 1);
            }
            if (i + 1 < n && nums.get(i)  < nums.get(i + 1)) {
                swap(nums, i, i + 1);
            }
        }
        return nums;
    }

    private static void swap(List<Integer> nums, int i, int j) {
        Integer t = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, t);
    }

}
