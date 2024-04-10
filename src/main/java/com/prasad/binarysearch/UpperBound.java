package com.prasad.binarysearch;

public class UpperBound {

    public static void main(String[] args) {
        int[] arr = {1,4,7,8,10};
        System.out.println(upperBound(arr, 7, 5));
    }
    public static int upperBound(int []arr, int x, int n){
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start)/2;
            if (arr[mid] <= x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}
