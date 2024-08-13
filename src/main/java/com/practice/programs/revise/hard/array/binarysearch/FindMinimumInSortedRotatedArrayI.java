package com.practice.programs.revise.hard.array.binarysearch;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 * TC: O(log n), AS: O(1)
 * Concepts:
 * BINARY_SEARCH
 */
public class FindMinimumInSortedRotatedArrayI {

    /**
     * If whole array is sorted, find min directly
     * If left half is sorted, find min from left half and continue searching in other half
     * If right half is sorted, find min from right half and continue searching in other half
     */
    public int findMin(int[] nums) {
        int min = nums[0];
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            min = Math.min(min, nums[mid]);
            if (nums[left] <= nums[right]) { // whole array is sorted
                min = Math.min(min, nums[left]);
                break;
            } else if (nums[left] <= nums[mid]) { // left half is sorted
                min = Math.min(min, nums[left]);
                left = mid + 1;
            } else { // right half is sorted
                min = Math.min(min, nums[mid]);
                right = mid - 1;
            }
        }
        return min;
    }
}
