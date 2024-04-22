package com.prasad.companies.servicenow;

class MedianOf2SortedArraysLC {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if (n > m) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int half = (n + m + 1) / 2;

        int start = 0;
        int end = n;

        while (start <= end) {
            int i = start + (end - start) / 2;
            int j = half - i;

            int aLeft = i > 0 ? nums1[i - 1] : Integer.MIN_VALUE;
            int aRight = i < n ? nums1[i] : Integer.MAX_VALUE;
            int bLeft = j > 0 ? nums2[j - 1] : Integer.MIN_VALUE;
            int bRight = j < m ? nums2[j] : Integer.MAX_VALUE;

            if (aLeft <= bRight && bLeft <= aRight) {
                if ((n + m) % 2 == 0) {
                    return ((double) Math.max(aLeft, bLeft) + (double) (Math.min(aRight, bRight))) / 2;
                } else {
                    return Math.max(aLeft, bLeft);
                }
            } else if (aLeft > bRight) {
                end = i - 1;
            } else {
                start = i + 1;
            }
        }
        return -1;
    }

}