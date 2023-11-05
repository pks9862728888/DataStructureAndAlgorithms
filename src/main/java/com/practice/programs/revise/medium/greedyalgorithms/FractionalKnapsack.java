package com.practice.programs.revise.medium.greedyalgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * TC: O(n log n), AS: O(n)
 * Greedy approach
 */
class FractionalKnapsack {

    // Try to maximize values for a bag of finite capacity such that value to Wt ratio is maximized
    // We can take fractional value if capacity is not yet satisfied

    // If question was asking that you can't pick fractional values, then greedy approach can't be used

    static double fractionalKnapsack(int n, int capacity, int[] wt, int[] val) {
        List<Tuple> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            items.add(new Tuple(wt[i], val[i]));
        }
        Collections.sort(items);
        double maxItems = 0.0;
        for (Tuple item: items) {
            // Pick up entire item if possible
            if (item.wt < capacity) {
                maxItems += item.val;
                capacity -= item.wt;
            } else {
                // Pick up fractional item
                maxItems += capacity * item.valueToWtRatio;
                break;
            }
        }
        return maxItems;
    }

    private static class Tuple implements Comparable<Tuple> {
        int wt;
        int val;
        double valueToWtRatio;
        Tuple (int wt, int val) {
            this.wt = wt;
            this.val = val;
            this.valueToWtRatio = (val * 1.0) / wt;
        }
        @Override
        public int compareTo(Tuple t) {
            return -1 * Double.compare(valueToWtRatio, t.valueToWtRatio);
        }
    }
}
