package com.prasad.binarysearch;

import java.util.Arrays;

public class AggressiveCowsOptimal {

    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int n = stalls.length;
        int maxDiff = stalls[n - 1] - stalls[0];
        if (k == 2) {
            return maxDiff;
        }
        int low = 1;
        int high = maxDiff;
        int ans = 1;

        while (low <= high) {
            int mid = (low + high)/2;
            if (canCowsBePlaced(stalls, mid, k)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private static boolean canCowsBePlaced(int[] stalls, int diff, int k) {
        int cowsPlaced = 1;
        int prevPlacedStall = stalls[0];
        int n = stalls.length;

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