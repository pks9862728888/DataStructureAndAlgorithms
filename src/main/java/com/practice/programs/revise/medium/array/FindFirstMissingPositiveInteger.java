package com.practice.programs.revise.medium.array;

/**
 * TC: O(n^2), AS: O(1)
 */
public class FindFirstMissingPositiveInteger {

    // nums contains +ve and -ve integer
    // Edge cases:
    // All -ve integer, -1. -2. -3, ans = 0
    // All +ve integer, 1, 2, 3, ans = 4

    public static int firstMissingPositiveInteger(int[] nums) {
        cyclicSort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i] - 1) {
                return i + 1;
            }
        }
        return Math.max(0, nums[nums.length - 1] + 1);
    }

    private static void cyclicSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            while (i != (arr[i] - 1)) {
                int otherIdx = arr[i] - 1;
                if (otherIdx < 0 || otherIdx >= arr.length || otherIdx == arr[otherIdx]) {
                    break;
                }
                // swap
                int temp = arr[i];
                arr[i] = arr[otherIdx];
                arr[otherIdx] = temp;
            }
        }
    }
}
