package com.practice.programs.revise.medium.recursionbacktracking;

import java.util.ArrayList;
import java.util.List;

/**
 * TC: O(n * 2^n), AS: O(n), where n = array length,
 * For AS, result space is ignored, result will be of size 2^n
 */
public class FindAllPossibleSubsets {

    public static void main(String[] args) {
        FindAllPossibleSubsets ob = new FindAllPossibleSubsets();
        System.out.println(ob.palindromePartitioning("abba"));
    }

    private List<List<String>> palindromePartitioning(String s) {
        List<List<String>> res = new ArrayList<>();
        find(s, 0, res, new ArrayList<>());
        return res;
    }

    private void find(String s, int st, List<List<String>> res, List<String> splitWd) {
        if (st >= s.length()) {
            res.add(new ArrayList<>(splitWd));
            return;
        }
        for (int i = st; i < s.length(); i++) {
            if (isPalindrome(s, st, i)) {
                splitWd.add(s.substring(st, i + 1));
                find(s, i + 1, res, splitWd);
                splitWd.remove(splitWd.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int st, int end) {
        while (st < end) {
            if (s.charAt(st++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
