package com.practice.programs.revise.medium.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://www.naukri.com/code360/problems/merge-k-sorted-arrays_975379?leftPanelTabValue=PROBLEM
 * TC: O(n log k), where k = no of sorted arrays, n = total no of elements
 * AS: O(k)
 * Concepts:
 * MIN_HEAP
 */
public class MergeKSortedList {

    public static ArrayList<Integer> mergeKSortedArrays(
            ArrayList<ArrayList<Integer>> arrays, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        buildPq(pq, arrays);
        ArrayList<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            res.add(curr.val);
            if (curr.hasNext()) {
                curr.update();
                pq.add(curr);
            }
        }
        return res;
    }

    private static void buildPq(
            PriorityQueue<Node> pq, ArrayList<ArrayList<Integer>> arrays) {
        for (List<Integer> arr: arrays) {
            pq.add(new Node(arr));
        }
    }

    private static class Node {
        List<Integer> list;
        Integer val;
        int currIdx;

        public Node(List<Integer> list) {
            this.list = list;
            this.currIdx = 0;
            this.val = list.get(this.currIdx);
        }

        public int size() {
            return list.size();
        }

        public boolean hasNext() {
            return currIdx + 1 < size();
        }

        public void update() {
            this.val = list.get(++this.currIdx);
        }
    }
}
