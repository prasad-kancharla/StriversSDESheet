package com.prasad.arraysii;

public class GetInversionsBruteForce {
    public static long getInversions(long arr[], int n) {
        long count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}