package com.practice.programs.revise.medium.graph.directed.toposort;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * https://www.geeksforgeeks.org/problems/alien-dictionary/1
 * TC: O(m * k^2) where m = max length of word
 * AS: O(k^2)
 * Concepts:
 * GRAPH
 * TOPOLOGICAL_SORT
 */
public class AlienDictionary {

    public String findOrder(String[] dict, int n, int k) {
        // Build graph
        Map<Character, Set<Character>> graph = new HashMap<>();
        buildGraph(graph, dict, n, k);
        // Apply topoSort
        // Build inOrder matrix
        Map<Character, Integer> indegreeMap = new HashMap<>();
        buildInDegreeMap(indegreeMap, graph);

        // Build queue
        Queue<Character> q = new LinkedList<>();
        addToQWithZeroIndegree(q, indegreeMap);
        StringBuilder res = new StringBuilder();
        while (!q.isEmpty()) {
            Character ch = q.poll();
            res.append(ch);
            Set<Character> adjChars = graph.get(ch);
            for (Character adjCh : adjChars) {
                if (indegreeMap.containsKey(adjCh)) {
                    int indegree = indegreeMap.get(adjCh) - 1;
                    if (indegree == 0) {
                        q.add(adjCh);
                        indegreeMap.remove(adjCh);
                    } else {
                        indegreeMap.put(adjCh, indegree);
                    }
                } else {
                    q.add(adjCh);
                }
            }
        }
        return res.toString();
    }

    private static void addToQWithZeroIndegree(
            Queue<Character> q, Map<Character, Integer> indegreeMap) {
        Set<Character> keys = new HashSet<>(indegreeMap.keySet());
        for (Character key : keys) {
            int freq = indegreeMap.get(key);
            if (freq == 0) {
                q.add(key);
                indegreeMap.remove(key);
            }
        }
    }

    private static void buildInDegreeMap(
            Map<Character, Integer> indegreeMap, Map<Character, Set<Character>> graph) {
        for (Map.Entry<Character, Set<Character>> entry : graph.entrySet()) {
            Character key = entry.getKey();
            Set<Character> values = entry.getValue();
            for (Character ch : values) {
                indegreeMap.put(ch, indegreeMap.getOrDefault(ch, 0) + 1);
            }
            indegreeMap.putIfAbsent(key, 0);
        }
    }

    private static void buildGraph(
            Map<Character, Set<Character>> graph, String[] dict, int n, int k) {
        for (int i = 0; i < k; i++) {
            graph.putIfAbsent((char) ('a' + i), new HashSet<>());
        }
        for (int i = 0; i < n - 1; i++) {
            String wd1 = dict[i];
            String wd2 = dict[i + 1];
            int l = Math.min(wd1.length(), wd2.length());
            for (int idx = 0; idx < l; idx++) {
                char ch1 = wd1.charAt(idx);
                char ch2 = wd2.charAt(idx);
                if (ch1 != ch2) {
                    graph.putIfAbsent(ch1, new HashSet<>());
                    graph.putIfAbsent(ch2, new HashSet<>());
                    graph.get(ch1).add(ch2);
                    break;
                }
            }
        }
    }
}
