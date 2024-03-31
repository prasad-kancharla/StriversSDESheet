package com.prasad.binarysearch;

public class NthPower {

    public static void main(String[] args) {
        System.out.println(NthRoot(9, 1953125));
    }

    public static int NthRoot(int n, int m) {
        int start = 1;
        int end = m;

        while (start <= end) {
            int mid = (start + end) / 2;
            long num = (long) Math.pow(mid, n);
            if (num < m) {
                start = mid + 1;
            } else if (num > m) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
