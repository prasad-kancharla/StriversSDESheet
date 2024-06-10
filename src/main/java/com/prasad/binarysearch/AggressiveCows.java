package com.prasad.binarysearch;

import java.util.Arrays;

public class AggressiveCows {

    public static void main(String[] args) {
        int[] stalls = {0, 3, 4, 7, 10, 9};
        System.out.println(aggressiveCows(stalls, 4));
    }

    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int n = stalls.length;
        if (k == 2) {
            return stalls[n - 1] - stalls[0];
        }
        int distance = 0;
        int start = 0;
        int end = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            boolean cowsCanBePlaced = checkIfCowsCanBePlaced(stalls, k, mid);
            if (cowsCanBePlaced) {
                distance = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return distance;
    }

    private static boolean checkIfCowsCanBePlaced(int[] stalls, int k, int distance) {
        int count = 1;
        int n = stalls.length;
        int prevGap = 0;
        for (int i = 1; i < n; i++) {
            int gap = prevGap + (stalls[i] - stalls[i - 1]);
            if (gap >= distance) {
                count++;
                prevGap = 0;
            } else {
                prevGap += (stalls[i] - stalls[i - 1]);
            }
        }
        return count >= k;
    }

}