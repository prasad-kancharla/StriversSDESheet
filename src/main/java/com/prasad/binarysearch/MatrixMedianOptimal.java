package com.prasad.binarysearch;

public final class MatrixMedianOptimal {
    public static int findMedian(int matrix[][], int m, int n) {
        int start = 1;
        int end = 1;
        for (int i = 0; i < m; i++) {
            start = Math.min(matrix[i][0], start);
            end = Math.max(matrix[i][n - 1], end);
        }

        while (start <= end) {
            int mid = (start + end)/2;
            if (getCount(matrix, m, n, mid) <= (m * n/2)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    private static int getCount(int[][] matrix, int m, int n, int target) {
        int count = 0;
        for (int i = 0; i < m; i++) {
            count += getUpperBound(matrix[i], n, target);
        }
        return count;
    }

    private static int getUpperBound(int[] arr, int n, int target) {
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = (start + end)/2;
            if (arr[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

}