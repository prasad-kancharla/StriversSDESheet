package com.prasad.binarysearch;

import java.util.ArrayList;

public class SearchInRotatedArray {

    public static int search(ArrayList<Integer> arr, int n, int k) {
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr.get(mid) == k) {
                return mid;
            }
            // left part is sorted
            if (arr.get(start) <= arr.get(mid)) {
                // check if target is in range
                if (arr.get(start) <= k && k <= arr.get(mid)) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else { // right part is sorted
                // check if target is in range
                if (arr.get(mid) <= k && k <= arr.get(end)) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

}