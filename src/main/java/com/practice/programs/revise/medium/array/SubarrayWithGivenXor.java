package com.practice.programs.revise.medium.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.interviewbit.com/problems/subarray-with-given-xor/
 * Concept:
 * HASHING
 * SUBARRAY_XOR
 */
public class SubarrayWithGivenXor {

    public int solve(ArrayList<Integer> list, int target) {
        return solveOptimal(list, target);
        // return solveBruteForce(list, target);
    }

    /**
     * TC: O(n), AS: O(n)
     */
    public int solveOptimal(List<Integer> list, int target) {
        int res = 0;
        Map<Integer, Integer> xorFreqMap = new HashMap<>(); // store freq of xors we encountered till now
        xorFreqMap.put(0, 1);
        int xor = 0;
        for (int ele : list) {
            xor ^= ele;
            int xorFreq = xorFreqMap.getOrDefault(xor ^ target, 0); // x = xor ^ target
            res += xorFreq;
            xorFreqMap.put(xor, xorFreqMap.getOrDefault(xor, 0) + 1);
        }
        return res;
    }

    /**
     * TC: O(n^2), AS: O(1)
     */
    public int solveBruteForce(List<Integer> list, int target) {
        int res = 0;
        int n = list.size();
        for (int i = 0; i < n; i++) {
            int xor = 0;
            for (int j = i; j < n; j++) {
                xor ^= list.get(j);
                if (xor == target) {
                    res++;
                }
            }
        }
        return res;
    }
}
