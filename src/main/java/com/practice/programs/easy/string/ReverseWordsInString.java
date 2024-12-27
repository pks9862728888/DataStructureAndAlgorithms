package com.practice.programs.easy.string;

import java.util.LinkedList;
import java.util.List;

/**
 * TC: O(n), AS: O(n)
 */
class ReverseWordsInString {

    // Multiple spaces should be replaced by only 1 space
    // hello      world -> world hello
    // one -> one

    // TC: O(n), AS: O(n)
    public static String reverseWords(String sentence) {
        // Convert string to mutable string and replace multiple blank spaces with single blank space
        StringBuilder rev = new StringBuilder(sentence.replaceAll("\\s+", " ").trim());

        // Reverse the entire string
        int strLen = rev.length();
        reverse(rev, 0, strLen - 1);

        // Iterate over the entire string and use two pointer approach to reverse the string
        int st = 0;
        int curr = 0;
        while (curr < strLen) {
            if (curr + 1 == strLen || rev.charAt(curr + 1) == ' ') {
                reverse(rev, st, curr);
                st = curr + 2;
                curr = st;
            } else {
                curr++;
            }
        }

        // Convert mutable string to string and return
        return new String(rev);
    }

    private static void reverse(StringBuilder sb, int st, int end) {
        int stop = (end - st) / 2;
        for (int counter = 0; counter <= stop; counter++) {
            int stIdx = st + counter;
            int endIdx = end - counter;
            char temp = sb.charAt(stIdx);
            sb.setCharAt(stIdx, sb.charAt(endIdx));
            sb.setCharAt(endIdx, temp);
        }
    }

    /**
     * TC: O(2n), AS: O(n)
     */
    public static String reverseString(String str) {
        // Use variable to
        // Iterate over the string
        // currentchar is '' and word is not empty, add to end of string builder
        List<String> l = new LinkedList<>();
        StringBuilder wd = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != ' ') {
                wd.append(ch);
            }
            if ((ch == ' ' || i + 1 == str.length()) && wd.length() > 0) {
                l.add(0, wd.toString());
                wd.setLength(0);
            }
        }
        return String.join(" ", l);
    }
}
