package com.prasad.arraysiii;

import java.util.ArrayList;

public class ReversePairsWithListInput {

    public static int reversePairs(ArrayList<Integer> arr) {
        int n = arr.size();
        return mergeSortAndCount(arr, 0, n - 1);
    }

    private static int mergeSortAndCount(ArrayList<Integer> arr, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            int count = 0;
            count += mergeSortAndCount(arr, start, mid);
            count += mergeSortAndCount(arr, mid + 1, end);
            count += merge(arr, start, mid, end);
            return count;
        }
        return 0;
    }

    private static int merge(ArrayList<Integer> arr, int start, int mid, int end) {
        int n = end - start + 1;
        int[] temp = new int[n];

        int i = start;
        int j = mid + 1;
        int k = 0;

        int count = 0;

        while (i <= mid && j <= end) {
            if ((long) arr.get(i) > 2 * (long) arr.get(j)) {
                count += (mid - i + 1);
                j++;
            } else {
                i++;
            }
        }

        i = start;
        j = mid + 1;

        while (i <= mid && j <= end) {
            if (arr.get(i) <= arr.get(j)) {
                temp[k++] = arr.get(i++);
            } else {
                temp[k++] = arr.get(j++);
            }
        }

        while (i <= mid) {
            temp[k++] = arr.get(i++);
        }

        while (j <= end) {
            temp[k++] = arr.get(j++);
        }

        for (int l = 0; l < n; l++) {
            arr.set(start + l, temp[l]);
        }
        return count;
    }

}