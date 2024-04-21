package com.prasad.companies.servicenow;

public class MedianOf2SortedArrays {

    public static void main(String[] args) {
        int[] a = {2, 4, 6};
        int[] b = {1, 3, 5};
        System.out.println(median(a, b));
    }

    public static double median(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int half = (n + m) / 2;

        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int i = start + (end - start) / 2;
            int j = half - (i + 1) - 1;

            int aLeft = i >= 0 ? a[i] : Integer.MIN_VALUE;
            int aRight = i + 1 < n ? a[i + 1] : Integer.MAX_VALUE;
            int bLeft = j >= 0 ? b[j] : Integer.MIN_VALUE;
            int bRight = j + 1 < n ? b[j + 1] : Integer.MAX_VALUE;

            if (aLeft <= bRight && bLeft <= aRight) {
                if ((n + m) % 2 == 0) {
                    return ((double) Math.max(aLeft, bLeft) + (double) Math.min(aRight, bRight)) / 2;
                } else {
                    return Math.min(aRight, bRight);
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