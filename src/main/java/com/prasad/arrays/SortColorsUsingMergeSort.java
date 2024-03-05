package com.prasad.arrays;

import java.util.Arrays;

class SortColorsUsingMergeSort {

    public static void main(String[] args) {
        int[] input = {2,0,2,1,1,0};
        new SortColorsUsingMergeSort().sortColors(input);
        System.out.println(Arrays.toString(input));
    }

    public void sortColors(int[] nums) {
        int n = nums.length;
        mergeSort(nums, 0, n - 1);
    }

    private void mergeSort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);
            mergeArrays(nums, start, end, mid);
        }
    }

    private void mergeArrays(int[] nums, int start, int end, int mid) {
        int n = end - start + 1;
        int[] sortedNums = new int[n];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                sortedNums[k++] = nums[i];
                i++;
            } else {
                sortedNums[k++] = nums[j];
                j++;
            }
        }

        while (i <= mid) {
            sortedNums[k++] = nums[i++];
        }

        while (j <= end) {
            sortedNums[k++] = nums[j++];
        }

        for (int l = start; l <= end; l++) {
            nums[l] = sortedNums[l - start];
        }
    }

}