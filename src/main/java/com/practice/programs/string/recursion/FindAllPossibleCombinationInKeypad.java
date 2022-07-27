package com.practice.programs.string.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class FindAllPossibleCombinationInKeypad {

    private static final HashMap<Integer, String> keys = new HashMap<>();

    static {
        keys.put(0, "");
        keys.put(1, "");
        keys.put(2, "abc");
        keys.put(3, "def");
        keys.put(4, "ghi");
        keys.put(5, "jkl");
        keys.put(6, "mno");
        keys.put(7, "pqrs");
        keys.put(8, "tuv");
        keys.put(9, "wxyz");
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findPossibleCombinations(0)));
        System.out.println(Arrays.toString(findPossibleCombinations(23)));
        System.out.println(Arrays.toString(findPossibleCombinations(234)));
    }

    private static String[] findPossibleCombinations(int no) {
        ArrayList<String> al = new ArrayList<>();
        al.add("");
        al = findPossibleCombinations(no, al);
        return al.toArray(new String[0]);
    }

    private static ArrayList<String> findPossibleCombinations(int no, ArrayList<String> al) {
        ArrayList<String> nal = new ArrayList<>();
        String val = keys.get(no % 10);

        // Add all possible combinations
        if (val.length() > 0) {
            for (char ch : val.toCharArray()) {
                al.forEach(e -> nal.add(ch + e));
            }
        } else {
            nal.add("");
        }

        // Revaluate no
        no /= 10;
        return (no == 0) ? nal : findPossibleCombinations(no, nal);
    }
}
