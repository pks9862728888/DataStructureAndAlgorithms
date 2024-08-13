package com.practice.programs.revise.hard.array.binarysearch;

/**
 * Assume no duplicates are present
 */
public class SearchInSortedRotatedArrayI {

    // 4 5 6 9 10 2 3, target = 5 -> 1

    // Complete the function implementation below
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[low] <= nums[mid]) { // left half is sorted
                // Check if target lies in left half range
                // if yes, then continue searching in the range, else continue search in right
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { // right half is sorted
                // Check if target lies in right half,
                // if yes, then continue searching in this range, else continue search in left
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
