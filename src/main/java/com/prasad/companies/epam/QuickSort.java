package com.prasad.companies.epam;

import java.util.List;

public class QuickSort {

    public static List<Integer> quickSort(List<Integer> arr) {
        int n = arr.size();
        quickSort(arr, 0, n - 1);
        return arr;
    }

    private static void quickSort(List<Integer> arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int index = reArrange(arr, start, end);
        quickSort(arr, start, index - 1);
        quickSort(arr, index + 1, end);
    }

    private static int reArrange(List<Integer> arr, int start, int end) {
        int left = start + 1;
        int right = end;

        while (left <= right) {
            if (arr.get(left) <= arr.get(start)) {
                left++;
            } else if (arr.get(right) > arr.get(start)) {
                right--;
            } else {
                int temp = arr.get(left);
                arr.set(left, arr.get(right));
                arr.set(right, temp);
                left++;
                right--;
            }
        }
        int temp = arr.get(start);
        arr.set(start, arr.get(left - 1));
        arr.set(left - 1, temp);
        return left - 1;
    }

}