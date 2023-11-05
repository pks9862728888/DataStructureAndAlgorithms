package com.practice.programs.medium.priorityqueue;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * If n = total no of elements combined, k = no of arrays
 * TC: O(k log k + n * log k) -> build pq = k, for each n element poll and add -> n * log k
 * AS: O(n + k) -> heap O(k), for ans array O(n)
 */
class MergeKSortedArrays {

    static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> arrays){
        // Build pq
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        buildPQ(pq, arrays);

        // Merge k sorted arrays
        ArrayList<Integer> mergedArray = new ArrayList<>();
        while (!pq.isEmpty()) {
            Pair minPair = pq.poll();
            mergedArray.add(minPair.element);
            minPair.incrementEleIdx();
            ArrayList<Integer> arr = arrays.get(minPair.arrIdx);
            if (minPair.eleIdx < arr.size()) {
                minPair.element = arr.get(minPair.eleIdx);
                pq.add(minPair);
            }
        }

        return mergedArray;
    }

    private static void buildPQ(PriorityQueue<Pair> pq, ArrayList<ArrayList<Integer>> arrays) {
        int stIdx = 0;
        for (int i = 0; i < arrays.size(); i++) {
            pq.add(new Pair(arrays.get(i).get(stIdx), stIdx, i));
        }
    }

    private static class Pair implements Comparable<Pair> {
        int element;
        int eleIdx;
        int arrIdx;
        Pair(int element, int eleIdx, int arrIdx) {
            this.element = element;
            this.eleIdx = eleIdx;
            this.arrIdx = arrIdx;
        }
        public void incrementEleIdx() {
            this.eleIdx++;
        }
        public int compareTo(Pair b) {
            return Integer.compare(this.element, b.element);
        }
    }
}
