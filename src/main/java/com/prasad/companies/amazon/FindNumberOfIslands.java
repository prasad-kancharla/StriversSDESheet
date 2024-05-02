package com.prasad.companies.amazon;

public class FindNumberOfIslands {

    public static void main(String[] args) {
        int[][] arr = {
                {0, 1, 1, 0, 0},
                {1, 0, 0, 1, 0},
                {0, 0, 1, 0, 0},
                {1, 0, 0, 0, 1},
        };
        System.out.println(getTotalIslands(arr));
    }

    public static int getTotalIslands(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    dfs(mat, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int[][] mat, int i, int j) {
        if (mat[i][j] == 0 || mat[i][j] == 2) {
            return;
        }
        mat[i][j] = 2;
        int[] x = {0, 1, -1, 0, 1, -1, 1, -1};
        int[] y = {1, 0, 0, -1, 1, -1, -1, 1};
        for (int k = 0; k < 8; k++) {
            int newI = i + x[k];
            int newJ = j + y[k];
            boolean isValid = newI >= 0 && newI < mat.length && newJ >= 0 && newJ < mat[0].length;
            if (isValid && mat[newI][newJ] == 1) {
                dfs(mat, newI, newJ);
            }
        }
    }

}