package com.practice.programs.revise.hard.array;

public class FindMinSpeedWithinWhichAllBooksCanBeReadInGivenTime {

    // 3 6 7 11, h = 8

    static int bookReading(int n, int h, int a[]) {
        int stK = 1;            // constant 1
        int endK = 1000000000;  // maximum possible value of arr[1]
        int minSpeed = 1;
        while (stK <= endK) {
            int mid = stK + (endK - stK) / 2;
            if (findHoursRequired(a, mid) <= h) {
                minSpeed = mid;
                endK = mid - 1;
            } else {
                stK = mid + 1;
            }
        }
        return minSpeed;
    }

    private static int findHoursRequired(int[] arr, int currSpeed) {
        int totalHoursRequired = 0;
        for (int booksCount: arr) {
            totalHoursRequired += (int) Math.ceil((double) booksCount / currSpeed);
        }
        return totalHoursRequired;
    }
}
