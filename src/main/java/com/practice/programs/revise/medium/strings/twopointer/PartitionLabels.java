package com.practice.programs.revise.medium.strings.twopointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TC: O(n), AS: O(1)
 * For example, given s = "bcbcdd", a valid partition is ["bcbc", "dd"].
 * However, partitions like ["bcb", "cdd"] or ["bc", "bc", "dd"]
 * are invalid because some letters appear in multiple parts.
 * Concepts:
 * TWO_POINTER, HASHMAP
 */
public class PartitionLabels {

  public List<Integer> partitionLabels(String s) {
    List<Integer> partitions = new ArrayList<>();
    Map<Character, Integer> lastIdx = new HashMap<>();
    int n = s.length();
    for (int i = 0; i < n; i++) {
      lastIdx.put(s.charAt(i), i);
    }

    int partitionStart = 0;
    int partitionEnd = 0;
    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      // get last index upto which curr partition can go
      partitionEnd = Math.max(partitionEnd, lastIdx.get(ch));
      if (i == partitionEnd) {
        partitions.add(partitionEnd - partitionStart + 1);
        partitionStart = partitionEnd + 1;
      }
    }

    return partitions;
  }

}
