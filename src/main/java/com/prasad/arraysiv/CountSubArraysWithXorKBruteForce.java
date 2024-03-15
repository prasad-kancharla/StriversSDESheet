package com.prasad.arraysiv;

public class CountSubArraysWithXorKBruteForce {

    public static void main(String[] args) {
        int[] input = {1, 3, 3, 3, 5};
        System.out.println(subarraysWithSumK(input, 6));
    }

    public static int subarraysWithSumK(int[] a, int b) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (getXor(a, i, j) == b) {
                    count++;
//                    System.out.println("start: " + i + ", end: " + j);
                }
            }
        }
        return count;
    }

    private static int getXor(int[] a, int i, int j) {
        int xor = 0;
        for (int k = i; k <= j; k++) {
            xor = xor ^ a[k];
        }
        return xor;
    }

}