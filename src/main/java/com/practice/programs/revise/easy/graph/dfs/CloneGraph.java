package com.practice.programs.revise.easy.graph.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/clone-graph/description/
 * TC: O(v + e), AS: O(v + e)
 * Concepts:
 * GRAPH
 * DFS_GRAPH
 */
public class CloneGraph {

    public Node cloneGraph(Node node) {
        Map<Integer, Node> cache = new HashMap<>();
        return clone(node, cache);
    }

    private Node clone(Node node, Map<Integer, Node> cache) {
        if (node == null) {
            return null;
        }
        Node clonedNode = new Node(node.val);
        cache.put(clonedNode.val, clonedNode);
        for (Node adjNode: node.neighbors) {
            Node clonedAdjNode = cache.containsKey(adjNode.val) ?
                    cache.get(adjNode.val) : clone(adjNode, cache);
            clonedNode.neighbors.add(clonedAdjNode);
        }
        return clonedNode;
    }

    private class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }
    }
}
