package com.practice.programs.revise.easy.array.binarysearch;

/**
 * TC: O(log n), AS: O(1)
 * <a href="https://www.codingninjas.com/codestudio/problems/square-root-integral_893351?leftPanelTab=0?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice link</a>
 * If perfect square does not exists, return floor of square root
 */
class FindSquareRootOfALargeInteger {

    // n is in the range of 10^9

    public static int sqrtN(long n) {
        if (n == 0 || n == 1) {
            return (int) n;
        }
        long st = 2;
        long end = n / 2;
        long res = 1;
        while (st <= end) {
            long mid = st + (end - st) / 2;
            if (mid <= n / mid) { // To prevent overflow we are not doing mid * mid <= n
                res = mid;
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return (int) res;
    }
}
