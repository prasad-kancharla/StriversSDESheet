package com.prasad.binarysearch;

import java.util.ArrayList;

public class FirstAndLastIndex {

    public static int[] firstAndLastPosition(ArrayList<Integer> arr, int n, int k) {
        int[] ans = new int[2];
        ans[0] = getFirstOccurrence(arr, 0, n - 1, k);
        ans[1] = getLastOccurrence(arr, 0, n - 1, k);
        return ans;
    }

    private static int getLastOccurrence(ArrayList<Integer> arr, int start, int end, int k) {
        int last = -1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (arr.get(mid) > k) {
                end = mid - 1;
            } else if (arr.get(mid) < k) {
                start = mid + 1;
            } else {
                last = mid;
                start = mid + 1;
            }
        }
        return last;
    }

    private static int getFirstOccurrence(ArrayList<Integer> arr, int start,  int end, int k) {
        int first = -1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (arr.get(mid) > k) {
                end = mid - 1;
            } else if (arr.get(mid) < k) {
                start = mid + 1;
            } else {
                first = mid;
                end = mid - 1;
            }
        }
        return first;
    }

}
