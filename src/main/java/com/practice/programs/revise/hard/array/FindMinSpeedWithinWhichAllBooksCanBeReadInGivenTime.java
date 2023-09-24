package com.practice.programs.revise.hard.array;

/**
 * TC: O(n log max[arr[i]]), AS: O(1)
 * Intuition: Minimize hourly speed of reading so that all books can be read by specified time
 * He can pick up books from only 1 rack in 1 hour
 * Input is array containing n racks, where arr[i] = no of books in that rack
 */
public class FindMinSpeedWithinWhichAllBooksCanBeReadInGivenTime {

    // 3 6 7 11, h = 8, minSpeed = 4

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
