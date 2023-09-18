package com.practice.programs.easy.arrays;

/**
 * TC: O(n), AS: O(1)
 */
public class CountSortInString {

    // abcdeedcbaa -> aaabbccddee

    public static void main(String[] args) {
        System.out.println(countSort(11, new StringBuilder("abcdeedcbaa")));
    }

    static StringBuilder countSort(int n, StringBuilder s) {
        // Find frequency
        int[] freq = new int['z' - 'a' + 1];
        for (int i = 0; i < n; i++) {
            ++freq[s.charAt(i) - 'a'];
        }

        // Update array
        int sbIdx = 0;
        for (int i = 0; i < freq.length; i++) {
            while (freq[i]-- > 0) {
                s.setCharAt(sbIdx++, (char) ('a' + i));
            }
        }
        return s;
    }
}
