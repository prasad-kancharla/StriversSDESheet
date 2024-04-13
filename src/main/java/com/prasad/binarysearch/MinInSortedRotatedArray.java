package com.prasad.binarysearch;

public class MinInSortedRotatedArray {

    public static void main(String[] args) {
        int[] arr = {35, 43, 45, 1, 2, 9, 12, 13, 19, 20, 26, 28, 29, 32};
        System.out.println(findMin(arr));
    }
    public static int findMin(int []arr) {
        int start = 0;
        int end = arr.length - 1;
        int min = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = start + (end - start)/2;
            min = Math.min(min, arr[mid]);
            if (arr[mid] <= arr[end]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return min;
    }
}