package com.practice.programs.revise.medium.greedyalgorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * TC: O(n log n), AS: O(n)
 */
class MinimumNoOfPlatformsRequiredForRailway {

    // Two trains can't be in same platform
    // Same platform can't be used if arrival time of 1 = departure time of other train in platform
    // (1, 2) (2, 3) (3, 4)

    static int minimumPlatforms(int n, int arrivals[], int departures[]){
        List<TrainSchedule> schedules = getTrainSchedules(arrivals, departures);
        schedules.sort(Comparator.comparingInt((TrainSchedule a) -> a.arrival)
                .thenComparingInt(a -> a.departure));
        PriorityQueue<Integer> platforms = new PriorityQueue<>();
        int maxPlatforms = 0;
        for (TrainSchedule schedule: schedules) {
            if (platforms.isEmpty() || platforms.peek() >= schedule.arrival) {
                platforms.add(schedule.departure);
                maxPlatforms = Math.max(maxPlatforms, platforms.size());
            } else {
                platforms.poll();
                platforms.add(schedule.departure);
            }
        }
        return maxPlatforms;
    }

    private static List<TrainSchedule> getTrainSchedules(int[] arrival, int[] departure) {
        List<TrainSchedule> trainSchedule = new ArrayList<>();
        for (int i = 0; i < arrival.length; i++) {
            trainSchedule.add(new TrainSchedule(arrival[i], departure[i]));
        }
        return trainSchedule;
    }

    private static class TrainSchedule {
        int arrival;
        int departure;
        public TrainSchedule(int a, int d) {
            arrival = a;
            departure = d;
        }
    }
}
