package com.prasad.binarysearch;

public class NumberOfTimesRotated {

    public static void main(String[] args) {
        int[] arr = {2,3,4,1};
        System.out.println(findKRotation(arr));
    }
    public static int findKRotation(int []arr){
        int start = 0;
        int end = arr.length - 1;

        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        while (start <= end) {
            int mid = start + (end - start)/2;
            if (arr[mid] < min) {
                min = arr[mid];
                minIndex = mid;
            }
            if (arr[mid] <= arr[end]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return minIndex;
    }
}