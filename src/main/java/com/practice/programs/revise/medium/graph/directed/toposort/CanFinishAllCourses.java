package com.practice.programs.revise.medium.graph.directed.toposort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/course-schedule/submissions/1334720649/
 * Given prereq array of DG, find if all courses can be finished, nodes are 0 to n - 1
 * TC: O(v + e), AS: O(v + e)
 * Concepts:
 * GRAPH
 * TOPOLOGICAL_SORT
 */
public class CanFinishAllCourses {

    public boolean canFinish(int n, int[][] prereq) {
        // build graph
        List<List<Integer>> graph = buildGraph(prereq, n);
        // apply topo sort to figure out if its possible or not
        int[] indegree = calculateIndegree(graph, n);
        Queue<Integer> nodesWithZeroIndegree = addNodesHavingZeroIndegree(indegree, n);
        while (!nodesWithZeroIndegree.isEmpty()) {
            Integer curr = nodesWithZeroIndegree.poll();
            List<Integer> adjNodes = graph.get(curr);
            for (Integer adjNode: adjNodes) {
                indegree[adjNode]--;
                if (indegree[adjNode] == 0) {
                    nodesWithZeroIndegree.add(adjNode);
                }
            }
        }
        return allZero(indegree);
    }

    private boolean allZero(int[] indegree) {
        for (int e: indegree) {
            if (e != 0) {
                return false;
            }
        }
        return true;
    }

    private Queue<Integer> addNodesHavingZeroIndegree(int[] indegree, int n) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        return q;
    }

    private int[] calculateIndegree(List<List<Integer>> graph, int n) {
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            List<Integer> adjNodes = graph.get(i);
            for (Integer adjNode: adjNodes) {
                indegree[adjNode]++;
            }
        }
        return indegree;
    }

    private List<List<Integer>> buildGraph(int[][] prereq, int n) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e: prereq) {
            graph.get(e[0]).add(e[1]);
        }
        return graph;
    }

}
