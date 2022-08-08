package com.demo.dp;

public class SmallestSuperSequence {

    public static void main(String[] args) {
        // Their smallest super sequence can be "abc" which has length = 3.
        System.out.println(smallestSuperSequenceIterative("ab", "ac"));
        System.out.println(smallestSuperSequenceIterative("pqqrpt", "qerepct")); // 9
    }

    public static int smallestSuperSequenceIterative(String str1, String str2) {
        if (str1.isEmpty()) {
            return str2.length();
        } else if (str2.isEmpty()) {
            return str1.length();
        }

        int[][] memo = new int[str1.length() + 1][str2.length() + 1];

        for (int i = str1.length(); i >= 0; i--) {
            for (int j = str2.length(); j >= 0; j--) {
                if (i == str1.length() && j == str2.length()) {
                    // Both strings are empty
                    memo[i][j] = 0;
                } else if (i == str1.length() || j == str2.length()) {
                    // One of the string is empty
                    int res = Math.min(get(i + 1, j, memo), get(i, j + 1, memo));
                    memo[i][j] = res == Integer.MAX_VALUE ? 1 : 1 + res;
                } else if (str1.charAt(i) == str2.charAt(j)) {
                    int res = get(i + 1, j + 1, memo);
                    memo[i][j] = 1 + (res == Integer.MAX_VALUE ? 0 : res);
                } else {
                    int res = Math.min(get(i + 1, j, memo), get(i, j + 1, memo));
                    memo[i][j] = res == Integer.MAX_VALUE ? 0 : (1 + res);
                }
            }
        }

        return memo[0][0];
    }

    private static int get(int i, int j, int[][] memo) {
        if (i >= memo.length || j >= memo[0].length) {
            return Integer.MAX_VALUE;
        }
        return memo[i][j];
    }
}