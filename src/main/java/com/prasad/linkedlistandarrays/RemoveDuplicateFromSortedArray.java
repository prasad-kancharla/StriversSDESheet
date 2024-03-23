package com.prasad.linkedlistandarrays;

public class RemoveDuplicateFromSortedArray {
    public static int removeDuplicates(int[] arr,int n) {
        if (n < 2) {
            return n;
        }
        int count = 1;
        int i = 1;
        while (i < n) {
            if (arr[i] == arr[i - 1]) {
                i++;
            } else {
                count++;
                i++;
            }
        }
        return count;
    }
}