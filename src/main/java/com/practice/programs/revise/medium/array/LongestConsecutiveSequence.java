package com.practice.programs.revise.medium.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://www.codingninjas.com/codestudio/problems/longest-successive-elements_6811740?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * Concepts:
 * HASHING
 * LCS
 */
class LongestConsecutiveSequence {

    // You can re-arrange the array to form longest consecutive sequence
    public static void main(String[] args) {
        System.out.println(longestSuccessiveElements(
                new int[]{15, 6, 2, 1, 16, 4, 2, 29, 9, 12, 8, 5, 14, 21, 8, 12, 17, 16, 6, 26, 3}));  // 6
    }

    public static int longestSuccessiveElements(int[] arr) {
//        return longestSuccessiveEleBetterApproach(arr);
        return longestSuccessiveElementOptimal(arr);
    }

    // TC: O(2n) AS: O(n)
    private static int longestSuccessiveElementOptimal(int[] arr) {
        // Store distinct elements in set
        // Iterate through each element in the set
        //      If ele - 1 is present in set -> do nothing
        //      If ele - 1 is not present in set (head of seq) -> find longest seq
        // Idea is after seen set is created, then only for the root of a sequence find the length of sequence
        if (arr.length == 0) return 0;
        Set<Integer> seen = new HashSet<>();
        for (int n: arr) seen.add(n);
        int longestConsecutive = 1;
        for (int n: arr) {
            if (!seen.contains(n - 1)) { // means this is the start of sequence
                int consecutives = 1;
                while (seen.contains(++n)) consecutives++;
                longestConsecutive = Math.max(longestConsecutive, consecutives);
            }
        }
        return longestConsecutive;
    }

    // TC: O(nlog n + n), AS: O(1)
    private static int longestSuccessiveEleBetterApproach(int[] arr) {
        Arrays.sort(arr);
        int lse = arr.length > 0 ? 1 : 0;
        int currSeq = 1;
        int prev = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - prev == 1) {
                currSeq++;
            } else if (prev != arr[i]) {
                currSeq = 1;
            }
            lse = Math.max(currSeq, lse);
            prev = arr[i];
        }
        return lse;
    }
}
