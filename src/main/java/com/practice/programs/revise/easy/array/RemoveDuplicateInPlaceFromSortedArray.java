package com.practice.programs.revise.easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Expected TC: O(n), SC: O(1)
 * Concept: Two pointer approach
 * <a href="https://takeuforward.org/data-structure/remove-duplicates-in-place-from-sorted-array/">practice link</a>
 */
class RemoveDuplicateInPlaceFromSortedArray {

    public static void main(String[] args) {
        List<Integer> al = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4, 5, 5));
        System.out.println(removeDuplicatesAndGetCountDistinctElements(al, al.size()));  // 5
    }

    public static int removeDuplicatesAndGetCountDistinctElements(List<Integer> arr, int n) {
        if (arr.size() <= 1) {
            return arr.size();
        }
        int leftIdx = 0;
        for (int currIdx = 1; currIdx < n; currIdx++) {
            if (!arr.get(leftIdx).equals(arr.get(currIdx))) {
                arr.set(++leftIdx, arr.get(currIdx));
            }
        }
        return leftIdx + 1;
    }
}
