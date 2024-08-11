package com.practice.programs.revise.easy.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * TC: O(n), AS: O(n)
 * <a href="https://www.codingninjas.com/codestudio/problems/reading_6845742?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice link</a>
 * https://leetcode.com/problems/two-sum/submissions/1351649393/
 * Concept:
 * HASHING
 */
class TwoSumProblem {

    // 4, 1, 2, 3, 1, target = 5, yes

    public static String read(int n, int []book, int target){
        Set<Integer> pages = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (book[i] != target && pages.contains(target - book[i])) {
                return "YES";
            }
            pages.add(book[i]);
        }
        return "NO";
    }

    public int[] betterTwoSumHashing(int[] nums, int target) {
        Map<Integer, Integer> seenNoMap = new HashMap<>();
        int idx = 0;
        for (int n: nums) {
            if (seenNoMap.containsKey(target - n)) {
                return new int[] {idx, seenNoMap.get(target - n)};
            }
            seenNoMap.put(n, idx++);
        }
        return new int[0];
    }

}
