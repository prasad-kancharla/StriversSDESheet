package com.prasad.binarysearch;

public class NumberOfOccurrence {

    public static int count(int arr[], int n, int x) {
        int firstOccurrence = getFirstOrLastOccurrence(arr, n, x, true);
        int lastOccurrence = getFirstOrLastOccurrence(arr, n, x, false);
        if (firstOccurrence == -1) {
            return 0;
        }
        return lastOccurrence - firstOccurrence + 1;
    }

    private static int getFirstOrLastOccurrence(int[] arr, int n, int k, boolean isFirstOccurrence) {
        int start = 0;
        int end = n - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > k) {
                end = mid - 1;
            } else if (arr[mid] < k) {
                start = mid + 1;
            } else {
                ans = mid;
                if (isFirstOccurrence) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }

}
