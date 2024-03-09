package com.prasad.arraysiii;

class SearchInA2DMatrix {

    public static void main(String[] args) {
        int[][] input = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
//        int[][] input = {{1}};
        System.out.println(new SearchInA2DMatrix().searchMatrix(input, 16));

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int row = getCorrectRow(matrix, n, m, target);

        int start = 0;
        int end = m - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target > matrix[row][mid]) {
                start = mid + 1;
            } else if (target < matrix[row][mid]) {
                end = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    private int getCorrectRow(int[][] matrix, int n, int m, int target) {

        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target > matrix[mid][0]) {
                start = mid + 1;
            } else if (target < matrix[mid][0]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        if (end >= 0) {
            return end;
        }
        return start;
    }

}