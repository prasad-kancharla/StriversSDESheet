package com.prasad.binarysearch;

public class SearchInsertPosition {
    public static int searchInsert(int [] arr, int m){
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start)/2;
            if (arr[mid] < m) {
                start = mid + 1;
            } else if (arr[mid] > m) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return start;
    }
}