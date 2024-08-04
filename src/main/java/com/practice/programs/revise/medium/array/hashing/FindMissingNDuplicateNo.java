package com.practice.programs.revise.medium.array.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://www.interviewbit.com/problems/repeat-and-missing-number-array/
 * TC: O(n)
 * AS: O(n)
 * Numbers starts from 1 to n
 * Concepts:
 * HASHING
 */
public class FindMissingNDuplicateNo {

    public List<Integer> repeatedNumber(final List<Integer> list) {
        Set<Integer> seen = new HashSet<>();
        // Find duplicate no
        Integer duplicateNo = null;
        for (Integer no: list) {
            if (!seen.add(no)) {
                duplicateNo = no;
            }
        }
        // Find missing no
        int missingNo = -1;
        for (int i = 1; ; i++) {
            if (!seen.contains(i)) {
                missingNo = i;
                break;
            }
        }
        return new ArrayList<>(Arrays.asList(duplicateNo, missingNo));
    }
}
