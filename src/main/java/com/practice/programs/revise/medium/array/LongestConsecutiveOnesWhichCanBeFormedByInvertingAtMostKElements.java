package com.practice.programs.revise.medium.array;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * TC: O(n), AS: O(n)
 * <a href="https://www.codingninjas.com/studio/problems/maximum-consecutive-ones_892994?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Longest consecutive ones</a>
 */
class LongestConsecutiveOnesWhichCanBeFormedByInvertingAtMostKElements {

    // 1 0 0 1 1 0 1, k = 1 -> result = 4

    public static int longestSubSeg(List<Integer> arr , int n, int k) {
        // Keep left pointer to point at start, left = 0
        // Keep queue to store inversion idx
        // Keep track of longSubSeg = 0
        // Iterate over the array
        //		If ele == 0
        //			while noOfInversion >= k
        //				left = pop idx from queue + 1
        //			put currIdx into queue since its inverted
        //		Update longSubSeg if its right - left + 1 is longest
        int left = 0;
        Queue<Integer> inversionIdxQ = new LinkedList<>();
        int longestSubSeqLen = 0;
        for (int currIdx = 0; currIdx < n; currIdx++) {
            if (arr.get(currIdx) == 0) {
                while (!inversionIdxQ.isEmpty() && inversionIdxQ.size() >= k) {
                    left = inversionIdxQ.poll() + 1;
                }
                if (k > 0) {  // Can invert curr element
                    inversionIdxQ.add(currIdx);
                } else {  // Inversion not allowed
                    left = currIdx + 1;
                }
            }
            if (left <= currIdx) {
                longestSubSeqLen = Math.max(longestSubSeqLen, currIdx - left + 1);
            }
        }

        return longestSubSeqLen;
    }
}
