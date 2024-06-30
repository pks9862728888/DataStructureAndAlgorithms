package com.practice.programs.revise.medium.bitmanipulation;

import java.util.ArrayList;
import java.util.List;

public class FindPowerSet {

    /**
     * Find power set
     * Input: nums = [1,2,3]
     * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     * <a href="https://leetcode.com/problems/subsets/">Practice Problem</a>
     * TC: O(n * 2^n)
     * AS: O(2^n)
     * Concept:
     * BIT_MANIPULATION
     * POWER_SET
     * At max there can be 2^n - 1 combinations based on which bit is set
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        int n = nums.length;
        int maxNo = (1 << n) - 1; // 2 ^ n - 1
        for (int no = 0; no <= maxNo; no++) {
            List<Integer> set = new ArrayList<>();
            for (int bit = 0; bit < n; bit++) {
                if ((no & (1 << bit)) != 0) { // if bit is set
                    set.add(nums[bit]);
                }
            }
            subsets.add(set);
        }
        return subsets;
    }
}
