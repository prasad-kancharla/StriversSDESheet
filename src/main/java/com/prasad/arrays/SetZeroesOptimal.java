package com.prasad.arrays;

class SetZeroesOptimal {

    public static void main(String[] args) {
        int[][] input1 = {{0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}};
        int[][] input2 = {{1,0,2}};
        new SetZeroesOptimal().setZeroes(input2);
        System.out.println(2);
    }

    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int col0 = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    if (i == 0) {
                        col0 = 0;
                    } else {
                        matrix[i][0] = 0;
                    }
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }

        if (col0 == 0) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }
    }

}