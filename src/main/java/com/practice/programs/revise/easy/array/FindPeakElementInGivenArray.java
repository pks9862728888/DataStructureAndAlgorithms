package com.practice.programs.revise.easy.array;

/**
 * TC: O(log n), AS: O(1)
 */
class FindPeakElementInGivenArray {

    // If strictly increasing -> peak = last ele
    // If strictly decreasing -> peak = first ele
    // else peak = arr[mid] > prev && arr[mid] < end

    // 1 2 3 1, peakEleIdx = 2

    static int peakElement(int arr[]) {
        if (arr.length == 1) {
            return 0;
        }
        int st = 0;
        int end = arr.length - 1;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (mid == 0) {
                if (arr[mid] > arr[mid + 1]) {
                    return mid;
                } else {
                    st = mid + 1;
                }
            } else if (mid == arr.length - 1) {
                if (arr[mid] > arr[mid - 1]) {
                    return mid;
                } else {
                    end = mid - 1;
                }
            } else if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid] > arr[mid - 1]) {
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
