package com.practice.programs.revise.medium.dp.tabulization;

public class LongestCommonSubstring {

    /**
     * TC: O(m * n), AS: O(m * n)
     * Intuition: If currChar matches, then total length of substring will be 1 + prev match count
     * abcjklp acjkp, lcs = 3, cjk
     * wasdijkl wsdjkl, lcs = 3, jkl
     */
    static int longestCommonSubstring(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int lcs = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                int res = 0;
                if (i != 0 && j != 0) {
                    res = s1.charAt(i - 1) == s2.charAt(j - 1) ? 1 + dp[i - 1][j - 1] : 0;
                }
                dp[i][j] = res;
                lcs = Math.max(lcs, res);
            }
        }
        return lcs;
    }
}
