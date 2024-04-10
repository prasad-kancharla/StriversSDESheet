package com.prasad.binarysearch;

public class LowerBound {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3};
        System.out.println(lowerBound(arr,4, 2));
    }
    public static int lowerBound(int []arr, int n, int x) {
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start)/2;
            if (arr[mid] < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}