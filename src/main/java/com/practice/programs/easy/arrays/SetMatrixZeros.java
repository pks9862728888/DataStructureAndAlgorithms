package com.practice.programs.easy.arrays;

import java.util.*;

/**
 * TC: O(1) - lookup in hashset + O(m*n) - for finding 0 row and col + O(m*n) - for updating = O(m * n)
 * AS: O(m + n) - for storing unique 0 rows and column for update
 * <a href="https://leetcode.com/problems/set-matrix-zeroes/description/">Practice Link</a>
 */
public class SetMatrixZeros {

    public void setZeroes(int[][] m) {
        Set<Integer> r = new HashSet<>();
        Set<Integer> c = new HashSet<>();

        // Find rows and columns which should be updated
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] == 0) {
                    r.add(i);
                    c.add(j);
                }
            }
        }

        // Update to zero
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (r.contains(i) || c.contains(j)) {
                    m[i][j] = 0;
                }
            }
        }
    }

}
