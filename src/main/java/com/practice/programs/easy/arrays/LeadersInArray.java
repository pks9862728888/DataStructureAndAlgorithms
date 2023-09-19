package com.practice.programs.easy.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * TC: O(n + nlog n), AS: O(n)
 * <a href="https://www.codingninjas.com/codestudio/problems/superior-elements_6783446?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice link</a>
 */
public class LeadersInArray {

    public static List<Integer> superiorElements(int[] arr) {
        List<Integer> superiorElements = new ArrayList<>();
        int maxSoFar = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            // Find superior elements
            if (arr[i] > maxSoFar) {
                superiorElements.add(arr[i]);
                maxSoFar = arr[i];
            }
        }

        Collections.sort(superiorElements);
        return superiorElements;
    }

}
