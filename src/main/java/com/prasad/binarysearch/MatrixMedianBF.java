package com.prasad.binarysearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class MatrixMedianBF {
    public static int findMedian(int matrix[][], int m, int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                list.add(matrix[i][j]);
            }
        }
        Collections.sort(list);
        return list.get((list.size() - 1)/2);
    }
}