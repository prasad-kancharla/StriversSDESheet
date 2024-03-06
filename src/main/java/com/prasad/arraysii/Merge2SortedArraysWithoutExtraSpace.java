package com.prasad.arraysii;

import java.util.Arrays;

public class Merge2SortedArraysWithoutExtraSpace {

    public static void mergeTwoSortedArraysWithoutExtraSpace(long[] a, long[] b) {
        int n = a.length;
        int m = b.length;

        int i = n - 1;
        int j = 0;

        // The final solution will be such that a will have the min elements
        // and b will have the max elements.
        // The final state should be the max of a is less than or equal min of b

        while (a[i] > b[j]) {
            long temp = a[i];
            a[i] = b[j];
            b[j] = temp;
            i--;
            j++;
        }

        // the above step messes up the sort order of a and b. so we need to sort them
        // but sorting using inbuilt method will use extra space O(log n)
        // we can use bubble sort and make sure not extra space is used
        Arrays.sort(a);
        Arrays.sort(b);
    }

}