package com.practice.programs.revise.medium.greedyalgorithms;

import java.util.ArrayList;


/**
 * TC: O(n), AS: O(1)
 * Greedy approach, VVVVIP
 */
class GasStationFindMinimumPositionForStartingForCircularTraversal {

    // If gas >= 0 then traversal is possible
    // gas - 5 1 2 3 4
    // fuel - 4 2 3 1 5
    // ans = 4 (consider 1 indexed)

    static int circularRace(int n, ArrayList<Integer> gas, ArrayList<Integer>burn) {
        if (!canTraverse(gas, burn, n)) {
            return -1;
        }
        int remainingGas = 0;
        int stGasStation = 0;
        for (int currSt = 0; currSt < n; currSt++) {
            remainingGas += getRemainingGas(gas, burn, currSt);
            if (remainingGas < 0) {
                stGasStation = currSt + 1;
                remainingGas = 0;
            }
        }
        return stGasStation + 1;
    }

    private static boolean canTraverse(ArrayList<Integer>gas, ArrayList<Integer>burn, int n) {
        int remainingGas = 0;
        for (int i = 0; i < n; i++) {
            remainingGas += getRemainingGas(gas, burn, i);
        }
        return remainingGas >= 0;
    }

    private static int getRemainingGas(ArrayList<Integer>gas, ArrayList<Integer>burn, int idx) {
        return gas.get(idx) - burn.get(idx);
    }

}
