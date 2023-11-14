package com.practice.programs.revise.medium.recursionbacktracking;

import java.util.ArrayList;

/**
 * TC: O(2^n), AS: O(n)
 */
class TowerOfHanoi {

    ArrayList<String> towerOfHanoi(int n) {
        ArrayList<String> res = new ArrayList<>();
        traverse(n, 'A', 'C', 'B', res);
        return res;
    }

    private void traverse(int n, char from, char to, char helper, ArrayList<String> res) {
        if (n == 1) {
            res.add(n + " " + from + " " + to);
            return;
        }
        traverse(n - 1, from, helper, to, res);
        res.add(n + " " + from + " " + to);
        traverse(n - 1, helper, to, from, res);
    }
}
