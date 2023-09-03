package com.practice.programs.revise.hard.twopointer;

/**
 * <a href="https://leetcode.com/problems/trapping-rain-water/description/">Practice link</a>
 * <a href="https://youtu.be/m18Hntz4go8?si=KzkMilxCfQOtXZwS">Video solution</a>
 */
class RainWaterTrappingProblem {

    public static void main(String[] args) {
        System.out.println(getTrappedWater(2, 1, 1, 4)); // 3
        System.out.println(getTrappedWaterOpt(2, 1, 1, 4)); // 3
    }

    public static long getTrappedWaterOpt(long... arr) {
        // TC: O(n), AS: O(1)
        // Initialize leftMax, rightMax, left pointer, and right pointer
        // while (left pointer <= right pointer)
        // If arr[left pointer] <= arr[right pointer] (means in right there is always block > min(arr[eft pointer]))
        //      if (arr[left pointer] >= leftMax)
        //          then no water will be stored, so update leftMax
        //      else
        //          update res = leftMax - arr[i]
        //      left pointer ++
        // else (means in left there is always a block which is greater than current block)
        //      if (arr[right pointer] >= rightMax)
        //          then no water will be stored, so update rightMax
        //      else
        //           update res = rightMax - arr[i]
        //      right pointer --
        int n = arr.length;
        long lm = 0;
        long rm = 0;
        int lp = 0, rp = n - 1;
        long res = 0;
        while (lp <= rp) {
            if (arr[lp] <= arr[rp]) {
                if (arr[lp] >= lm) {
                    lm = arr[lp];
                } else {
                    res += lm - arr[lp];
                }
                lp++;
            } else {
                if (arr[rp] >= rm) {
                    rm = arr[rp];
                } else {
                    res += rm - arr[rp];
                }
                rp--;
            }
        }

        return res;
    }

    // TC: O(n), AS: O(n)
    public static long getTrappedWater(long... arr) {
        // Loop through the array and store prefix max and suffix max
        // For each element in array
        // max rainwater = 0, Math.min(preMax - suffMax) - current
        int n = arr.length;
        long[] pm = new long[n];
        long[] sm = new long[n];
        // Find prefix and suffix max
        long pmax = Integer.MIN_VALUE;
        long smax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            // Prefix max
            pmax = Math.max(arr[i], pmax);
            pm[i] = pmax;

            // Suffix max
            smax = Math.max(arr[n - i - 1], smax);
            sm[n - i - 1] = smax;
        }

        // Find max trapped rainwater
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.min(pm[i], sm[i]) - arr[i];
        }
        return res;
    }
}
