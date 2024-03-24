package com.prasad.linkedlistandarrays;

import java.util.List;

public class MaxConsecutiveOnesCN {

    public static void main(String[] args) {
        List<Integer> input = List.of(0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0);
        System.out.println(new MaxConsecutiveOnesCN().longestSubSeg(input, 15, 3));
    }

    public static int longestSubSeg(List<Integer> arr, int n, int k) {
        int i = 0;
        int j = 0;
        int zeroesCount = 0;
        int maxLen = 0;

        while (j < n) {
            if (arr.get(j) == 0) {
                zeroesCount++;
            }
            while (zeroesCount > k) {
                if (arr.get(i) == 0) {
                    zeroesCount--;
                }
                i++;
            }
            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }
        return maxLen;
    }

}