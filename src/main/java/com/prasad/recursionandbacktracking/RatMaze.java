package com.prasad.recursionandbacktracking;

import java.util.*;
public class RatMaze {
    public static List<String> ratMaze(int [][]mat) {
        List<String> paths = new ArrayList<>();
        int n = mat.length;
        int m = mat[0].length;
        if (mat[n - 1][m - 1] == 0) return paths;
        getPaths(0, 0, n, m, mat, new StringBuilder(), paths);
        return paths;
    }

    private static void getPaths(int i, int j, int n, int m, int[][] mat, StringBuilder path, List<String> paths) {
        if (i == n - 1 && j == m - 1) {
            paths.add(new String(path));
            return;
        }

        if ((i >= n || j >= m) || mat[i][j] == 0) {
            return;
        }

        char[] chars = {'D', 'U', 'L', 'R'};
        int[] x = {1, -1, 0, 0};
        int[] y = {0, 0, -1, 1};

        mat[i][j] = -1;

        for (int k = 0; k < 4; k++) {
            int newI = i + x[k];
            int newJ = j + y[k];
            if (isValidCell(newI, newJ, n, m) && mat[newI][newJ] != -1) {
                path.append(chars[k]);
                getPaths(newI, newJ, n, m, mat, path, paths);
                path.deleteCharAt(path.length() - 1);
            }
        }

        mat[i][j] = 1;
    }

    private static boolean isValidCell(int i, int j, int n, int m) {
        if (i >= 0 && j >= 0 && i < n && j < m) {
            return true;
        }
        return false;
    }
}