package com.prasad.companies.epam;

public class MergeSort {

    public static void mergeSort(int[] arr, int n) {
        mergeSort(arr, 0, n - 1);
    }

    private static void mergeSort(int[] arr, int start, int end) {
		if (start < end) {
			int mid = start + (end - start) / 2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid + 1, end);
			merge(arr, start, end, mid);
		}
    }

    private static void merge(int[] arr, int start, int end, int mid) {
        int n = end - start + 1;
        int[] temp = new int[n];

        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= end) {
            temp[k++] = arr[j++];
        }

        for (int l = start; l <= end; l++) {
			arr[l] = temp[l - start];
        }
    }

}