package com.practice.programs.revise.medium.greedyalgorithms;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * TC: O(n log n + n * m where m = max deadline), AS: O(n)
 * Greedy algorithm
 */
class JobSequencingProblem {

    // (100, 2), (1, 19), (1, 25), (2, 27), (1, 15) -> max profit = 100 + 27 = 127
    // Only 1 job can be done in 1 unit of time

    static int jobSequencing(int n, int deadlines[], int profits[]) {
        Set<Integer> availableSlots = getAvailableSlots(deadlines);
        List<ProfitDeadlinePair> jobPairs = generateProfitDeadlinePair(deadlines, profits);
        jobPairs.sort((j1, j2) -> -1 * Integer.compare(j1.profit, j2.profit));
        int totalProfit = 0;
        for (ProfitDeadlinePair jobPair: jobPairs) {
            Optional<Integer> slotToWork = findSlotToWork(jobPair.deadline, availableSlots);
            if (slotToWork.isPresent()) {
                totalProfit += jobPair.profit;
                availableSlots.remove(slotToWork.get());
            }
        }
        return totalProfit;
    }

    private static Optional<Integer> findSlotToWork(int deadline, Set<Integer> slots) {
        for (int i = deadline; i > 0 && !slots.isEmpty(); i--) {
            if (slots.contains(i)) {
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }

    private static Set<Integer> getAvailableSlots(int[] deadlines) {
        Integer maxSlot = Arrays.stream(deadlines)
                .boxed()
                .max(Comparator.comparingInt(Integer::intValue))
                .get();
        return IntStream.rangeClosed(1, maxSlot)
                .boxed()
                .collect(Collectors.toSet());
    }

    private static List<ProfitDeadlinePair> generateProfitDeadlinePair(int[] deadlines, int[] profits) {
        List<ProfitDeadlinePair> jobPairs = new ArrayList<>();
        for (int i = 0; i < profits.length; i++) {
            jobPairs.add(new ProfitDeadlinePair(profits[i], deadlines[i]));
        }
        return jobPairs;
    }

    private static class ProfitDeadlinePair {
        int profit;
        int deadline;
        ProfitDeadlinePair(int p, int d) {
            profit = p;
            deadline = d;
        }
    }
}
