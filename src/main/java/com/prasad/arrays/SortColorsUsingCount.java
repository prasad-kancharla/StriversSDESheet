package com.prasad.arrays;

public class SortColorsUsingCount {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else if (nums[i] == 1) {
                oneCount++;
            } else {
                twoCount++;
            }
        }
        int k = 0;
        for (int i = 0; i < zeroCount; i++) {
            nums[k++] = 0;
        }
        for (int i = 0; i < oneCount; i++) {
            nums[k++] = 1;
        }
        for (int i = 0; i < twoCount; i++) {
            nums[k++] = 2;
        }
    }
}
