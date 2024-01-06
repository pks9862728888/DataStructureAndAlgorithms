package com.practice.programs.easy.slidingwindow;

import java.util.*;
import java.util.stream.Collectors;

/**
 * TC: O (n * k) AS: O(n)
 */
public class FindRepeatedSubSequenceFromDna {

    public static Set<String> findRepeatedSequences(String s, int k) {
        Set<String> seenSeq = new HashSet<>();
        Set<String> res = new HashSet<>();
        StringBuilder currSeq = new StringBuilder(s.substring(0, k));
        seenSeq.add(currSeq.toString());
        int n = s.length();
        for (int end = k; end < n; end++) {
            currSeq.deleteCharAt(0);
            currSeq.append(s.charAt(end));
            String seq = currSeq.toString();
            if (!seenSeq.add(seq)) {
                res.add(seq);
            }
        }
        return res;
    }
}
