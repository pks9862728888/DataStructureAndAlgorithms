package com.practice.programs.revise.medium.greedyalgorithms;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMinRefuellingStopsToReachDestination {

    // There are n stops
    // At each stop, fuel can be loaded
    // Station[0] = distance, station[1] = fuel which can be loaded
    // Vehicle starts with startFuel and it can travel distance = startFuel
    // Find min refuelling which is required to reach target distance

    // For e.g. [(5, 8), (5, 11), (10, 3), (13, 7), (21, 6)], startFuel = 9, target = 33
    // So if he re-fuells at 2nd, 4th and 5th stations,
    // then total distance which can be covered = 9 + 11 + 7 + 6 = 33
    // So target can be reached, so ans = 3

    // TC: O(n log n), AS: O(n)
    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (startFuel >= target) { // No re-fuelling is required
            return 0;
        }
        int i = 0;
        int n = stations.length;
        int stops = 0;
        int maxDistance = startFuel;
        PriorityQueue<Integer> maxFuelHeap = new PriorityQueue<>(Collections.reverseOrder());
        while (maxDistance < target) {
            if (i < n && stations[i][0] <= maxDistance) { // Station is within reach
                maxFuelHeap.add(stations[i][1]);
                i++;
            } else if (maxFuelHeap.isEmpty()) { // Fuel is empty, but re-fuelling stations are not present
                break;
            } else { // Fuel is empty, but re-fuelling can be done
                maxDistance += maxFuelHeap.poll();
                stops++;
            }
        }

        return maxDistance >= target ? stops : -1;
    }
}
