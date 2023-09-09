package com.practice.programs.easy.twopointer;

/**
 * TC: O(n^2), AS: O(1)
 */
public class FindTripletWithMaxSumInUnSortedArray {

    // conditions:
    // arr[i] < arr[j] < arr[k]
    // i < j < k
    // 3 7 4 2 5 7 5 -> 4 + 5 + 7 = 16
    // 5 2 4 5 -> 2 + 4 + 5 = 11
    // 3 2 1 -> 3 + 2 + 1 = 6

    static long maxSumTriplet(int n, long arr[]) {
        long maxSum = 0;
        // Fix mid and we iterate from 1 to n - 2 since left < mid < right shuld be satisfied
        for (int mid = 1; mid <= n - 2; mid++) {
            // Find left max which is less than curr element
            long leftMaxLessThanCurr = -1;
            for (int leftIdx = mid - 1; leftIdx >= 0; leftIdx--) {
                if (arr[leftIdx] < arr[mid] && arr[leftIdx] > leftMaxLessThanCurr) {
                    leftMaxLessThanCurr = arr[leftIdx];
                }
            }

            // Find right max which is greater than curr ele
            long rightMaxGreaterThanCurr = -1;
            for (int rightIdx = mid + 1; rightIdx < n; rightIdx++) {
                if (arr[rightIdx] > arr[mid] && arr[rightIdx] > rightMaxGreaterThanCurr) {
                    rightMaxGreaterThanCurr = arr[rightIdx];
                }
            }

            if (leftMaxLessThanCurr != -1 && rightMaxGreaterThanCurr != -1) {
                maxSum = Math.max(maxSum, leftMaxLessThanCurr + arr[mid] + rightMaxGreaterThanCurr);
            }
        }

        return maxSum;
    }

}
