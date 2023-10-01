package com.practice.programs.revise.easy.array.binarysearch;

/**
 * TC: O(log maxElementInArr), AS: O(1)
 * <a href="https://www.codingninjas.com/codestudio/problems/minimum-rate-to-eat-bananas_7449064?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
class KyokoEatingBananasMinimizeEatingRate {

    // 7 15 6 3, h = 3, ans = 5
    // He can eat from only 1 pile in an hour, find minimum rate such that he can eat all bananas in h hours

    public static int minimumRateToEatBananas(int []v, int h) {
        int st = 1;
        int end = findMax(v);
        int minRate = 1;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            int timeTaken = getTimeTakenInHours(v, mid);
            if (timeTaken <= h) {
                minRate = mid;
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return minRate;
    }

    private static int getTimeTakenInHours(int[] v, int rate) {
        int timeTaken = 0;
        for (int bananas: v) {
            timeTaken += Math.ceil(bananas * 1.0 / rate);
        }
        return timeTaken;
    }

    private static int findMax(int[] v) {
        int max = Integer.MIN_VALUE;
        for (int i: v) {
            max = Math.max(max, i);
        }
        return max;
    }

}
