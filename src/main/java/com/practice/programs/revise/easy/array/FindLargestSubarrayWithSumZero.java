package com.practice.programs.revise.easy.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TC: O(2n), AS: O(n)
 */
public class FindLargestSubarrayWithSumZero {

    // 2 3 1 -4 0 6 -> 3 1 -4 0

    static ArrayList<Integer> largestSubarraySumZero(int n, int arr[]) {
        // Create a map to store prefixSum -> idx map
        // Create variable to store prefixSum, stIdx = -1, endIdx = -1
        // Iterate over array and calculate prefixSum
        //      If currentSum = 0, then updateStIdx = 0, endIdx = currIdx, put in map if not already exists
        //      If prefixSum already exists in array, that means sum of subArray = 0, update st = map.get(prefixSum), endIdx = currIdx only if no other interval was found, or current interval is bigger
        //      else, only put prefix sum in map
        Map<Long, Integer> prefixSumIdxMap = new HashMap<>();
        long currentSum = 0;
        int stIdx = -1;
        int endIdx = -1;
        for (int i = 0; i < n; i++) {
            currentSum += arr[i];
            if (currentSum == 0) {
                stIdx = 0;
                endIdx = i;
            } else if (prefixSumIdxMap.containsKey(currentSum)) {
                if (stIdx == -1) {
                    stIdx = prefixSumIdxMap.get(currentSum) + 1;
                    endIdx = i;
                } else if (i - prefixSumIdxMap.get(currentSum) > endIdx - stIdx + 1) { // get max interval
                    stIdx = prefixSumIdxMap.get(currentSum) + 1;
                    endIdx = i;
                }
            }

            // Add to map only if its not added (to find max interval)
            if (!prefixSumIdxMap.containsKey(currentSum)) {
                prefixSumIdxMap.put(currentSum, i);
            }
        }

        // Return result
        ArrayList<Integer> res = new ArrayList<>();
        if (stIdx == -1) {
            res.add(-1);
        } else {
            addElementsToList(res, arr, stIdx, endIdx);
        }
        return res;
    }

    private static void addElementsToList(List<Integer> list, int[] arr, int st, int end) {
        for (int i = st; i <= end; i++) {
            list.add(arr[i]);
        }
    }
}
