package com.practice.programs.recursion.string;

import java.util.ArrayList;

public class FindAllSubsequence {

    /**
     * Input = "abc"
     * Output = ["", "a", "b", "c", "ab", "ac", "bc", "abc"]
     * Order of output does not matter
     * TC: 2^n AS: n, where n = no of letters in string
     */
    public static void main(String[] args) {
        System.out.println(findAllSubsequences("abc"));
        System.out.println(findAllSubsequences(""));
    }

    private static ArrayList<String> findAllSubsequences(String str) {
        ArrayList<String> al = new ArrayList<>();
        if (str == null) {
            return al;
        }
        al.add("");
        findAllSubsequences(str, 0, al);
        return al;
    }

    private static void findAllSubsequences(String str, int idx, ArrayList<String> al) {
        if (idx == str.length()) {
            return;
        }
        char ch = str.charAt(idx);
        ArrayList<String> tal = new ArrayList<>();
        for (String s: al) {
            tal.add(s + ch);
        }
        al.addAll(tal);
        findAllSubsequences(str, idx + 1, al);
    }
}
