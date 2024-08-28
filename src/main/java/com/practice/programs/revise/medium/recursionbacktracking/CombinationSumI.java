package com.practice.programs.revise.medium.recursionbacktracking;

import java.util.*;

/**
 * https://leetcode.com/problems/combination-sum/description/
 * TC: O( 2 ^ n )
 * AS: O( k * x ) + O(k / m), where k is the average length of each set and x is the number of such sets we have.
 * m = min no in array
 * Concepts:
 * BACKTRACKING
 */
public class CombinationSumI {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = candidates.length;
        findCombination(candidates, 0, n, target, new ArrayList<>(), res);
        return res;
    }

    private void findCombination(
            int[] candidates, int idx, int n, int target, List<Integer> combination, List<List<Integer>> combinations) {
        if (target == 0) {
            combinations.add(new ArrayList<>(combination));
            return;
        }
        if (target < 0 || idx == n) {
            return;
        }
        // take
        combination.add(candidates[idx]);
        findCombination(candidates, idx, n, target - candidates[idx], combination, combinations);
        combination.remove(combination.size() - 1);
        // dont take
        findCombination(candidates, idx + 1, n, target, combination, combinations);
    }
}
