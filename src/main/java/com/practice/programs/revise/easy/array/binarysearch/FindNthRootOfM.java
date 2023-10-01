package com.practice.programs.revise.easy.array.binarysearch;

class FindNthRootOfM {

    public static void main(String[] args) {
        System.out.println(NthRoot(3, 27));
    }

    public static int NthRoot(int n, int m) {
        if (m == 1) {
            return 1;
        }
        int st = 2;
        int end = m / 2;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            int comparisonRes = getComparisonRes(m, mid, n);
            if (comparisonRes == 0) {
                return mid;
            } else if (comparisonRes > 0) {
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return -1;
    }

    private static int getComparisonRes(long target, int no, int times) {
        long res = 1;  // Use long to prevent overflow
        for (int i = 1; i <= times; i++) {
            res = res * no;
            if (res > target) {
                return 1;
            }
        }
        return res == target ? 0 : -1;
    }
}
