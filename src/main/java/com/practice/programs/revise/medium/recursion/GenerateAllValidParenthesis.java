package com.practice.programs.revise.medium.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * TC: O((1 / (n + 1)) * (2n C n)), which is approximated to: O((4 ^ n) / sqrt(n))
 * AS: O(2n) -> 2n is recursion depth
 */
class GenerateAllValidParenthesis {

    // n = 2, ans = [(()), ()()]
    // Concept, we can't add closed braces count if countClosed > countOpened so far

    public List<String> balancedBraces(int n) {
        List<String> res = new ArrayList<>();
        generateBalancedBraces("", 0, 0, n, res);
        return res;
    }

    private void generateBalancedBraces(
            String parenthesis, int openCount, int closedCount, int n, List<String> res) {
        if (parenthesis.length() == 2 * n) {
            res.add(parenthesis);
            return;
        }
        if (openCount < n) {
            generateBalancedBraces(parenthesis + '(', openCount + 1, closedCount, n, res);
        }
        if (closedCount < openCount) {
            generateBalancedBraces(parenthesis + ')', openCount, closedCount + 1, n, res);
        }
    }

}
