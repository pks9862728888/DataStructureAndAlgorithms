package com.demo.dp;

import java.util.HashMap;

public class LongestCommonSubsequence {

    /**
     * Subsequence traversal: Left -> Right only
     * Can skip one or more characters
     */
    public static void main(String[] args) {
        System.out.println(lcsRecursive("adebc", "dcadb"));
        System.out.println(lcsIterative("adebc", "dcadb"));
    }

    public static int lcsIterative(String s, String t) {
        HashMap<String, Integer> memo = new HashMap<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = t.length() - 1; j >= 0; j--) {
                lcs(s, t, i, j, memo);
            }
        }
        return memo.get(getKey(0, 0));
    }

	public static int lcsRecursive(String s, String t) {
		return lcs(s, t, 0, 0, new HashMap<>());
    }
    
    private static int lcs(String s, String t, int i, int j, HashMap<String, Integer> memo) {
        if (i >= s.length() || j >= t.length()) {
            return 0;
        } else if(memo.containsKey(getKey(i, j))) {
            return memo.get(getKey(i, j));
        } else if (s.charAt(i) == t.charAt(j)) {
            int res = 1 + lcs(s, t, i + 1, j + 1, memo);
            memo.put(getKey(i, j), res);
            return res;
        } else {
            int res = Math.max(
                    lcs(s, t, i + 1, j, memo),
                    lcs(s, t, i, j + 1, memo));
            memo.put(getKey(i, j), res);
            return res;
        }
    }
    
    private static String getKey(int i, int j) {
        return i + " " + j;
    }

}