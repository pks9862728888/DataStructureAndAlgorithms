package com.practice.programs.revise.medium.array;

/**
 * TC: O(n^2), AS: O(n^2)
 */
class PrintMatrixInSpiralOrder {

    public static void main(String args[]) {
        int n = 4;
        int result[][] = spiralMatrixII(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] spiralMatrixII(int n) {
        int[][] mat = new int[n][n];
        int count = 1;
        int l = 0, r = n - 1, t = 0, b = n - 1;

        while (count <= n * n) {
            // Traverse right
            for (int i = l; i <= r; i++) {
                mat[t][i] = count++;
            }
            t++;

            // Traverse down
            for (int i = t; i <= b; i++) {
                mat[i][r] = count++;
            }
            r--;

            // Traverse left
            for (int i = r; i >= l; i--) {
                mat[b][i] = count++;
            }
            b--;

            // Traverse up
            for (int i = b; i >= t; i--) {
                mat[i][l] = count++;
            }
            l++;
        }
        return mat;
    }
}
