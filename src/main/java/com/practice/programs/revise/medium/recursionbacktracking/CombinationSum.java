package com.practice.programs.revise.medium.recursionbacktracking;

import java.util.*;

/**
 * TC: O( 2 ^ T * k ), where T is the target and k is the average size of the set which stores a possible subset having sum equal to target.
 * AS: O( k * x ), where k is the average length of each set and x is the number of such sets we have.
 */
public class CombinationSum {

    // 4 7
    // 2
    // 3
    // 6
    // 7
    // res: [[2,2,3],[7]]

    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        findCombinations(candidates, 0, target, 0, new ArrayList<>(), res);
        Collections.sort(res, (a, b) -> {
            for (int i = 0; i < a.size() && i < b.size(); i++) {
                if (!a.get(i).equals(b.get(i))) {
                    return Integer.compare(a.get(i), b.get(i));
                }
            }
            return -1 * Integer.compare(a.size(), b.size());
        });
        return res;
    }

    private static void findCombinations(
            int[] candidates, int sum, int target, int idx, List<Integer> currComb,
            List<List<Integer>> res) {
        if (sum == target) {
            List<Integer> combCopy = new ArrayList<>(currComb);
            Collections.sort(combCopy);
            res.add(combCopy);
            return;
        } else if (sum > target || idx == candidates.length) {
            return;
        }
        // Exclude idx element
        findCombinations(candidates, sum, target, idx + 1, currComb, res);

        // Include idx element
        int element = candidates[idx];
        currComb.add(element);
        findCombinations(candidates, sum + element, target, idx, currComb, res);
        currComb.remove(currComb.size() - 1);
    }
}
