package com.practice.programs.easy.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * TC: O(n), AS: O(n)
 */
public class FindFirstMissingIntegerInAnArray {

    // 1, 2, 3 -> 4
    // 1, 3 -> 2
    // -1 1 -> 2
    // -1 3 2 -> 1
    // 3 4 -1 1 -> 2

    public int firstMissingPositive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int e : nums) {
            if (e > 0) {
                s.add(e);
            }
        }
        int i = 1;
        while (true) {
            if (s.contains(i)) {
                i++;
            } else {
                return i;
            }
        }
    }
}
