package com.practice.programs.revise.medium.graph.dag;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * TC: O(v + e) AS: O(v + e)
 */
public class CourseSchedule {

    public static void main(String[] args) {
        System.out.println(courseSchedule(2, new int[][] {{2, 1}}));
    }

    public static boolean courseSchedule(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses + 1];
        List<List<Integer>> graph = buildGraphAndUpdateIndegree(prerequisites, indegree, numCourses);
        Queue<Integer> q = addCoursesHavingZeroIndegree(indegree);
        if (q.isEmpty()) {
            return false;
        }
        while (!q.isEmpty()) {
            Integer curr = q.poll();
            for (int adjNode: graph.get(curr)) {
                indegree[adjNode]--;
                if (indegree[adjNode] == 0) {
                    q.add(adjNode);
                } else if (adjNode == curr) {
                    return false; // self loop
                }
            }
        }
        return !isCourseStillExistsWithNonZeroIndegree(indegree);
    }

    private static boolean isCourseStillExistsWithNonZeroIndegree(int[] indegrees) {
        for (int indegree: indegrees) {
            if (indegree != 0) {
                return true;
            }
        }
        return false;
    }

    private static Queue<Integer> addCoursesHavingZeroIndegree(int[] indegree) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        return q;
    }

    private static List<List<Integer>> buildGraphAndUpdateIndegree(
            int[][] prerequisites, int[] indegree, int n) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] preq: prerequisites) {
            int u = preq[0];
            int v = preq[1];
            indegree[u]++;
            graph.get(v).add(u);
        }
        return graph;
    }
}
