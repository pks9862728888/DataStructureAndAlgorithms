package com.practice.programs.revise.easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Expected TC: O(n), SC: O(1)
 * Concept: Two pointer approach
 * <a href="https://takeuforward.org/data-structure/remove-duplicates-in-place-from-sorted-array/">practice link</a>
 */
public class RemoveDuplicateInPlaceFromSortedArray {

    public static void main(String[] args) {
        List<Integer> al = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4, 5, 5));
        System.out.println(removeDuplicatesAndGetCountDistinctElements(al, al.size()));  // 5
    }

    public static int removeDuplicatesAndGetCountDistinctElements(List<Integer> arr, int n) {
        int i = 0;
        for (int j = 1; j < n; j++) {
            if (!arr.get(i).equals(arr.get(j))) {
                arr.set(++i, arr.get(j));
            }
        }
        return i + 1;
    }
}
