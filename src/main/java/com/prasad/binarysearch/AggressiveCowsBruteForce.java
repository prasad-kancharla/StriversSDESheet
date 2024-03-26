package com.prasad.binarysearch;

import java.util.Arrays;

public class AggressiveCowsBruteForce {

    public static void main(String[] args) {
        int[] input = {18, 27, 44, 77, 69, 19, 35, 83, 9, 64};
        System.out.println(aggressiveCows(input, 4));
    }

    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int n = stalls.length;
        int maxDiff = stalls[n - 1] - stalls[0];
        if (k == 2) return maxDiff;
        for (int i = 1; i < maxDiff; i++) {
            if (cowsCanBePlaced(stalls, i, k)) {
                continue;
            } else {
                return i - 1;
            }
        }
        return maxDiff;
    }

    private static boolean cowsCanBePlaced(int[] stalls, int diff, int k) {
        int cowsPlaced = 1;
        int n = stalls.length;
        int prevPlacedStall = stalls[0];
        for (int i = 1; i < n; i++) {
            if (stalls[i] - prevPlacedStall >= diff) {
                cowsPlaced++;
                prevPlacedStall = stalls[i];
                if (cowsPlaced == k) {
                    return true;
                }
            }
        }
        return false;
    }

}