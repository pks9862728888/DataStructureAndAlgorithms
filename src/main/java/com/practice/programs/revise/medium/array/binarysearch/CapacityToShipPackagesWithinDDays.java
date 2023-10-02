package com.practice.programs.revise.medium.array.binarysearch;

/**
 * TC: O(n + log(sum(weights))), AS: O(1)
 * <a href="https://www.codingninjas.com/codestudio/problems/capacity-to-ship-packages-within-d-days_1229379?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
class CapacityToShipPackagesWithinDDays {

    // 5 4 5 2 3 4 5 6, d = 5, ans = 9
    // Since these are package, only 1 package can be shipped per day

    public static int leastWeightCapacity(int[] weights, int d) {
        int st = 1;
        int end = sum(weights);
        int leastWeightCapacity = 1;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            int daysRequired = getDaysRequired(weights, mid);
            if (daysRequired > d) {
                st = mid + 1;
            } else {
                leastWeightCapacity = mid;
                end = mid - 1;
            }
        }
        return leastWeightCapacity;
    }

    private static int getDaysRequired(int[] weights, int maxWtPerDay) {
        int daysRequired = 0;
        int remWt = maxWtPerDay;
        for (int w: weights) {
            if (w > maxWtPerDay) { // maxWtPerDay is too low to ship entire wt
                return Integer.MAX_VALUE;
            }
            remWt -= w;
            if (remWt == 0) {
                daysRequired++;
                remWt = maxWtPerDay;
            } else if (remWt < 0) {
                daysRequired++;
                remWt = maxWtPerDay - w;
            }
        }
        return remWt == maxWtPerDay ? daysRequired : daysRequired + 1;
    }

    private static int sum(int[] w) {
        int s = 0;
        for (int weight: w) {
            s += weight;
        }
        return s;
    }

}
