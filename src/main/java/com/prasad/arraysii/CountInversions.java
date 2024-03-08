package com.prasad.arraysii;

public class CountInversions {

    public static long getInversions(long arr[], int n) {
        return mergeSortAndCount(arr, 0, arr.length - 1);
    }

    private static int mergeSortAndCount(long[] arr, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        int count1 = mergeSortAndCount(arr, start, mid);
        int count2 = mergeSortAndCount(arr, mid + 1, end);
        int count3 = merge(arr, start, end, mid);
        return count1 + count2 + count3;
    }

    private static int merge(long[] arr, int start, int end, int mid) {
        int n = end - start + 1;
        long[] temp = new long[n];

        int count = 0;

        int i = start;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                count += mid - i + 1;
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= end) {
            temp[k++] = arr[j++];
        }

        for (int l = 0; l < n; l++) {
            arr[l + start] = temp[l];
        }

        return count;
    }

}
