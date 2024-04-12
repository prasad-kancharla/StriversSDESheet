package com.prasad.binarysearch;

public class SearchInRotatedSortedArrayII {

    public static void main(String[] args) {
        int[] A = {1,0,1,1,1};
        System.out.println(searchInARotatedSortedArrayII(A, 0));
    }
    public static boolean searchInARotatedSortedArrayII(int []A, int key) {
        int start = 0;
        int end = A.length - 1;

        while (start <= end) {
            int mid = start + (end - start)/2;
            if (A[mid] == key) return true;

            if (A[start] == A[mid] && A[mid] == A[end]) {
                start = start + 1;
                end = end - 1;
                continue;
            }

            if (A[start] <= A[mid]) {
                if (A[start] <= key && key <= A[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (A[mid] <= key && key <= A[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }
}