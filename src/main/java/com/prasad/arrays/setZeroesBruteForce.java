package com.prasad.arrays;

import java.util.ArrayList;
import java.util.List;

class setZeroesBruteForce {

    public void setZeroesBruteForce(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        List<Pair> zeroes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    zeroes.add(new Pair(i, j));
                }
            }
        }

        int size = zeroes.size();
        for (int i = 0; i < size; i++) {
            updateRowAndColumn(zeroes.get(i).x, zeroes.get(i).y, n, m, matrix);
        }
    }

    private void updateRowAndColumn(int i, int j, int n, int m, int[][] matrix) {
        for (int x = 0; x < n; x++) {
            matrix[x][j] = 0;
        }
        for (int y = 0; y < m; y++) {
            matrix[i][y] = 0;
        }
    }

    class Pair {

        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

}