package com.practice.programs.revise.easy.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FindIntersectionOfTwoUnsortedArraysInAnyOrder {

    // 4 1 2 2 5
    // 2 2
    // Ans: 2 2

    /**
     * TC: O(n + m), AS: O(min(m, n))
     */
    static int[] intersectionOfTwoArrays2(int arr1[], int arr2[]) {
        // Generate freq of the shorter array to optimize space
        if (arr1.length > arr2.length) {
            return intersectionOfTwoArrays2(arr2, arr1);
        }
        // Find frequency of each element in arr1
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int e: arr1) {
            freqMap.put(e, freqMap.getOrDefault(e, 0) + 1);
        }
        // Find intersection
        List<Integer> intersection = new ArrayList<>();
        for (int e: arr2) {
            if (freqMap.containsKey(e)) {
                intersection.add(e);
                freqMap.put(e, freqMap.get(e) - 1);
                if (freqMap.get(e) == 0) {
                    freqMap.remove(e);
                }
            }
        }
        return intersection.stream().mapToInt(Integer::intValue).toArray();
    }
}
