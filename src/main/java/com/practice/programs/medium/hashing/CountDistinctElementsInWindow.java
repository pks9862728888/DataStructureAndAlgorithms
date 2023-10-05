package com.practice.programs.medium.hashing;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * TC: O(n), AS: O(n)
 */
public class CountDistinctElementsInWindow {

    // 1 2 1 3 4 3, window = 3, ans = 2 3 3 2
    // window has to be exact

    static ArrayList<Integer> countDistinctElements(int n, int window, int arr[]) {
        if (window > n) {
            return new ArrayList<>();
        }
        HashMap<Integer, Integer> hm = new HashMap<>();
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
            if ((i + 1) >= window) {
                al.add(hm.size());
                int stWindow = arr[i - window + 1];
                hm.put(stWindow, hm.getOrDefault(stWindow, 0) - 1);
                if (hm.get(stWindow) == 0) {
                    hm.remove(stWindow);
                }
            }
        }
        return al;
    }
}
