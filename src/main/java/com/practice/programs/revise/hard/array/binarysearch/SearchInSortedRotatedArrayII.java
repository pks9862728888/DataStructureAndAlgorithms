package com.practice.programs.revise.hard.array.binarysearch;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 * TC: O(log n), AS: O(1)
 * Concept:
 * BINARY_SEARCH
 */
public class SearchInSortedRotatedArrayII {

    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[low] == nums[high] || nums[low] == nums[mid] || nums[high] == nums[mid]) {
                // In this case we don't know which half to ignore, so can't ignore one half
                if (nums[low] == target) {
                    return true;
                }
                low++;
            } else if (nums[mid] > nums[low]) { // left half is sorted
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { // right half is sorted
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}
