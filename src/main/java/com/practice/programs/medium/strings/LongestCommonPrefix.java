package com.practice.programs.medium.strings;

/**
 * TC: O(n * k) AS: O(k), where k = length of longest word
 * <a href="https://www.codingninjas.com/studio/problems/longest-common-prefix_628874?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
class LongestCommonPrefix {

    // abcd, abc, ab -> ab
    // ab, AB -> -1

    public static String commonPrefix(String[] arr, int n) {
        StringBuilder lcp = new StringBuilder(arr[0]);
        for (int i = 1; i < n; i++) {
            String currWd = arr[i];
            int commIdx = 0;
            for (; commIdx < currWd.length() && commIdx < lcp.length(); commIdx++) {
                if (currWd.charAt(commIdx) != lcp.charAt(commIdx)) {
                    break;
                }
            }
            if (commIdx == 0) {
                lcp.setLength(0);
                break;
            } else {
                lcp.setLength(commIdx);
            }
        }
        return lcp.length() == 0 ? "-1" : lcp.toString();
    }
}
