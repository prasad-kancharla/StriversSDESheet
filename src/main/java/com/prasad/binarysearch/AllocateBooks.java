package com.prasad.binarysearch;

import java.util.ArrayList;
// https://www.youtube.com/watch?v=2JSQIhPcHQg
public class AllocateBooks {

    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        if (n < m) {
            return -1;
        }
        long start = 0;
        long end = 0;
        for (int i = 0; i < n; i++) {
            int numberOfPages = arr.get(i);
            start = Math.max(start, numberOfPages);
            end += numberOfPages;
        }

        long ans = -1;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (isValid(arr, n, m, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return (int) ans;
    }

    private static boolean isValid(ArrayList<Integer> arr, int n, int m, long pagesCount) {
        long sum = 0;
        int students = 1;

        for (int i = 0; i < n; i++) {
            sum += arr.get(i);
            if (sum > pagesCount) {
                students++;
                sum = arr.get(i);
            }
            if (students > m) {
                return false;
            }
        }
        return true;
    }

}