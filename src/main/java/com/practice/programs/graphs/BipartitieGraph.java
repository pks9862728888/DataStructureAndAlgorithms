package com.practice.programs.graphs;

import java.util.*;

/**
 * Graph that can be colored by 2 colors such that no two adjacent nodes have same color
 * TC : O(v + E)
 * AS : O(V)
 * <p>
 * We use BFS to do it (odd cycle in graph indicates not bipartitie, else bipartite)
 */
public class BipartitieGraph {

    public static void main(String[] args) {
        // Undirected cyclic graph (odd cycle)
        ArrayList<ArrayList<Integer>> g1 = new ArrayList<>();
        int v1 = 8;
        g1.add(new ArrayList<>(List.of(1)));  // 0
        g1.add(new ArrayList<>(Arrays.asList(0, 2, 5))); // 1
        g1.add(new ArrayList<>(Arrays.asList(1, 3)));  // 2
        g1.add(new ArrayList<>(Arrays.asList(2, 4)));  // 3
        g1.add(new ArrayList<>(Arrays.asList(5, 6)));  // 4
        g1.add(new ArrayList<>(Arrays.asList(1, 4)));  // 5
        g1.add(new ArrayList<>(Arrays.asList(4, 7)));  // 6
        g1.add(new ArrayList<>(List.of(6)));  // 7
        System.out.println(isBipartiteBFS(v1, g1));

        // Undirected cyclic graph (even cycle)
        ArrayList<ArrayList<Integer>> g2 = new ArrayList<>();
        int v2 = 8;
        g2.add(new ArrayList<>(List.of(1)));  // 0
        g2.add(new ArrayList<>(Arrays.asList(0, 2, 6))); // 1
        g2.add(new ArrayList<>(Arrays.asList(1, 3)));  // 2
        g2.add(new ArrayList<>(Arrays.asList(2, 4)));  // 3
        g2.add(new ArrayList<>(Arrays.asList(5, 7)));  // 4
        g2.add(new ArrayList<>(Arrays.asList(4, 6)));  // 5
        g2.add(new ArrayList<>(Arrays.asList(1, 5)));  // 6
        g2.add(new ArrayList<>(List.of(4)));  // 7
        System.out.println(isBipartiteBFS(v2, g2));

    }

    private static boolean isBipartiteBFS(int v, ArrayList<ArrayList<Integer>> g1) {
        int[] color = new int[v];
        Arrays.fill(color, -1);

        for (int i = 0; i < v; i++) {
            if (color[i] == -1 && !checkBipartite(i, g1, color)) {
                // It was not visited earlier and it was not bipartitie
                return false;
            }
        }

        return true;
    }

    private static boolean checkBipartite(int c, ArrayList<ArrayList<Integer>> adj, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(c);

        // Randomly color start node
        color[c] = 0;

        while (!q.isEmpty()) {
            int curr = q.remove();
            for (int i : adj.get(curr)) {
                if (color[i] == -1) {
                    // Not colored, so color using opposite color and add in queue
                    color[i] = color[curr] == 0 ? 1 : 0;
                    q.add(i);
                } else if (color[i] == color[curr]) {
                    // Adjacent nodes color matched with current nodes color
                    return false;
                }
            }
        }

        return true;
    }
}
