package com.practice.programs.revise.medium.greedyalgorithms;

import java.util.ArrayList;
import java.util.Collections;

class FindMinimumNoOfBeesToReachHive {

    // Position of bees is provided
    // Position of hive is provided
    // We need to assign each bee to each hive such that time taken by bees to reach hive is minimum
    // Greedy Intuition: Assign first bee to first hive and so on
    // If we try to find closest position to each bee, then for next bee it might not work ->
    // so this intuition does not work, e.g. [1, 5], [-10, 1]

    public static int beesToHives(int n, ArrayList<Integer> beesPositions, ArrayList<Integer> hivesPosition) {
        Collections.sort(beesPositions);
        Collections.sort(hivesPosition);
        int maxTimeTaken = 0;
        for (int i = 0; i < n; i++) {
            maxTimeTaken = Math.max(maxTimeTaken, Math.abs(beesPositions.get(i) - hivesPosition.get(i)));
        }
        return maxTimeTaken;
    }
}
