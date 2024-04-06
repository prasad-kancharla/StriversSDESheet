package com.prasad.recursionandbacktracking;

public class MColoringProblem {

    static int[] color;

    public static String graphColoring(int[][] mat, int m) {
        int n = mat.length;
        color = new int[n];
        for (int i = 0; i < n; i++) {
            color[i] = -1;
        }
        if (colorGraph(0, mat, m)) {
            return "YES";
        }
        return "NO";
    }

    private static boolean colorGraph(int node, int[][] mat, int m) {
        int n = mat.length;
        if (node == n) {
            return true;
        }

        for (int i = 0; i < m; i++) {
            if (isSafeColor(node, mat,i)) {
                color[node] = i;
                if (colorGraph(node + 1, mat, m)) {
                    return true;
                }
                color[node] = -1;
            }
        }
        return false;
    }

    private static boolean isSafeColor(int node, int[][] mat, int c) {
        for (int j = 0; j < mat[node].length; j++) {
            if (mat[node][j] == 1 && color[j] == c) {
                return false;
            }
        }
        return true;
    }

}