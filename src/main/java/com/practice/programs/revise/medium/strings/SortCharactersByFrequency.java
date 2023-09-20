package com.practice.programs.revise.medium.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class SortCharactersByFrequency {

    public static void main(String[] args) {
        System.out.println(sortByFrequency("abAb"));
        System.out.println(sortByFrequency("abcAbc"));
        System.out.println(sortByFrequency("gggjhhh"));
    }

    /**
     * TC: O(2n + nlog n) AS: O(3n)
     */
    public static String sortByFrequency(String s) {
        int n = s.length();
        Map<Character, Integer> freqMap = new HashMap<>();
        Character[] arr = new Character[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.charAt(i);
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
        }
        Arrays.sort(arr,
                (ch1, ch2) -> {
                    int freq1 = freqMap.get(ch1);
                    int freq2 = freqMap.get(ch2);
                    if (freq1 == freq2) {
                        return (int) ch1 - (int) ch2;
                    } else {
                        return -1 * Integer.compare(freq1, freq2);
                    }
                });

        // Prepare string
        StringBuilder sb = new StringBuilder();
        for (Character ch : arr) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
