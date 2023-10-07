package com.practice.programs.revise.medium.hashing;

import java.util.*;

/**
 * TC: O(n log n), AS: O(1)
 * where n = length of vector
 */
public class KMostFreqWords {

    // a a b c b c, k = 2, res = a, b

    public static Vector<String> frequentWords(Vector<String> vec, int k) {
        // Get freq of all words
        Map<String, Integer> m = new HashMap<>();
        for (String s: vec) {
            m.put(s, m.getOrDefault(s, 0) + 1);
        }

        // Create list
        List<List<Object>> l = new ArrayList<>();
        for (Map.Entry<String, Integer> e : m.entrySet()) {
            List<Object> t1 = new ArrayList<>();
            t1.add(e.getKey());
            t1.add(e.getValue());
            l.add(t1);
        }

        // Sort list
        Collections.sort(l, (o1, o2) -> {
            int compare = -1 * Integer.compare((Integer) o1.get(1), (Integer) o2.get(1));
            if (compare == 0) {
                return ((String) o1.get(0)).compareTo((String) o2.get(0));
            }
            return compare;
        });

        // Return result
        Vector<String> res = new Vector<>(k);
        for (int i = 0; i < k; i++) {
            res.add((String) l.get(i).get(0));
        }
        return res;
    }
}
