package com.prasad.arraysii;

public class Merge2SortedArraysWithExtraSpace {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ans = new int[n + m];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                ans[k++] = nums1[i++];
            } else {
                ans[k++] = nums2[j++];
            }
        }

        while (i < m) {
            ans[k++] = nums1[i++];
        }
        while (j < n) {
            ans[k++] = nums2[j++];
        }

        for (int l = 0; l < m + n; l++) {
            nums1[l] = ans[l];
        }
    }
}