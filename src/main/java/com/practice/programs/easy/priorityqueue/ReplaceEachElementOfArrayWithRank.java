package com.practice.programs.easy.priorityqueue;

import java.util.*;

/**
 * TC: O(n log n) AS: O(2n)
 * <a href="https://www.codingninjas.com/studio/problems/replace-each-element-of-array-with-its-corresponding-rank_975384?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
class ReplaceEachElementOfArrayWithRank {

    public static List<Integer> replaceWithRank(List<Integer> arr, int n) {
        Map<Integer, Integer> rankMap = getRankMap(arr);
        List<Integer> res = new ArrayList<>();
        for (int e: arr) {
            res.add(rankMap.get(e));
        }
        return res;
    }

    private static Map<Integer, Integer> getRankMap(List<Integer> arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.addAll(arr);
        Map<Integer, Integer> rankMap = new HashMap<>();
        Integer prev = null;
        int rank = 0;
        while (!pq.isEmpty()) {
            Integer min = pq.poll();
            if (!min.equals(prev)) {
                rank++;
            }
            prev = min;
            rankMap.put(min, rank);
        }
        return rankMap;
    }
}
