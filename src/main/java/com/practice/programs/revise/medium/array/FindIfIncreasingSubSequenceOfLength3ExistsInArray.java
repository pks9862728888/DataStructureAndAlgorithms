package com.practice.programs.revise.medium.array;

import java.util.List;

public class FindIfIncreasingSubSequenceOfLength3ExistsInArray {

    // 4 1 6 2 3 -> true since 1, 2, 3 exists and i < j < k and arr[i] < arr[j] < arr[k]

    /**
     * Brute force:
     * TC: O(n^2), AS: O(1)
     */
    static String increasingTripleSubsequence(int n, List<Integer> nums) {

        for (int mid = 1; mid <= n - 2; mid++) {
            // Find ele in left half which is less than current
            int leftIdx = mid - 1;
            while (leftIdx >= 0) {
                if (nums.get(leftIdx--) < nums.get(mid)) {
                    break;
                }
            }

            // If ele in the left half found which satisfies the criteria
            if (leftIdx >= 0) {
                // Find ele in right half which is greater than current
                int rightIdx = mid + 1;
                while (rightIdx < n) {
                    if (nums.get(rightIdx++) > nums.get(mid)) {
                        return "true";
                    }
                }
            }
        }
        return "false";
    }

    /**
     * Optimal approach:
     * TC: O(n), AS: O(1)
     */
    static String increasingTripleSubsequenceOptimal(int n, List<Integer> nums) {
        // Intuition:
        // For each element try to put it in correct order i < j < k && arr[i] < arr[j] < arr[k]
        int left = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        for (int e: nums) {
            if (e < left) {
                left = e;
            } else if (e < mid) {
                mid = e;
            } else if (e > mid) {
                return "true";
            }
        }
        return "false";
    }
}
