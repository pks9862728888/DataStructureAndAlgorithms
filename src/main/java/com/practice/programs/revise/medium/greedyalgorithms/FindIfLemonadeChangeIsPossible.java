package com.practice.programs.revise.medium.greedyalgorithms;

/**
 * https://leetcode.com/problems/lemonade-change/
 * TC: O(n), AS: O(1)
 * Concepts:
 * GREEDY_ALGORITHM
 */
public class FindIfLemonadeChangeIsPossible {

    public boolean lemonadeChange(int[] bills) {
        boolean canChange = true;
        int f = 0, t = 0;
        for (int b: bills) {
            if (b == 5) {
                f += 1;
            } else if (b == 10) {
                if (f > 0) {
                    f -= 1;
                    t += 1;
                } else {
                    canChange = false;
                    break;
                }
            } else if (b == 20) {
                if (t > 0 && f > 0) {
                    t -= 1;
                    f -= 1;
                } else if (f >= 3) {
                    f -= 3;
                } else {
                    canChange = false;
                    break;
                }
            }
        }
        return canChange;
    }
}
