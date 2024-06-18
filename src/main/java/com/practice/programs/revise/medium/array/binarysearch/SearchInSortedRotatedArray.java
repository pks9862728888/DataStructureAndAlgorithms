package com.practice.programs.revise.medium.array.binarysearch;

public class SearchInSortedRotatedArray {

    /**
     * TC: O(log n), AS: O(1)
     * 4 5 6 7 1 2
     * search: 1, 3, ans: 4, -1
     * Concept:
     * BINARY_SEARCH
     */
    public int findPersonWithHeightH(int[] seq, int h) {
        int n = seq.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            // Case A: seq[mid] == h, return
            if (seq[mid] == h) {
                return mid;
            }
            // Case B: identify the sorted half and determine where to search
            else {
                if (seq[mid] <= seq[high]) {
                    // right half is sorted, so check if right half contains target else go in left
                    if (h >= seq[mid] && h <= seq[high]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                } else {
                    // left half is sorted, so check if left half contains target else go in right
                    if (h >= seq[low] && h <= seq[mid]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
            }
        }
        return -1;
    }
}
