package com.prasad.binarysearch;

public class KthElementOfSortedArray {

    public static void main(String[] args) {
        int[] array1 = {2, 3, 9, 9, 10, 11};
        int[] array2 = {1, 1, 2, 4, 5, 6, 7, 8, 8, 9, 9, 13};

        System.out.println(ninjaAndLadoos(array1, array2, 6,12,18));
    }
    public static int ninjaAndLadoos(int row1[], int row2[], int m, int n, int k) {
       int i = 0;
       int j = 0;
       int count = 0;

       while (i < m && j < n) {
           if (row1[i] <= row2[j]) {
               count++;
               if (count == k) return row1[i];
               i++;
           } else {
               count++;
               if (count == k) return row2[j];
               j++;
           }
       }

       while (i < m) {
           count++;
           if (count == k) return row1[i];
           i++;
       }

       while (j < n) {
           count++;
           if (count == k) return row2[j];
           j++;
       }
       return -1;
    }
}
