package com.prasad.arraysii;

import java.util.Arrays;

class FindDuplicate {

    public static void main(String[] args) {
        int[] input = {2, 5, 9, 6, 4, 3, 8, 9, 7, 1};
        System.out.println(new FindDuplicate().findDuplicate(input));
    }

    // if length of nums is n + 1, nums will have numbers from 1 to n
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            int correctIndex = nums[i] - 1;
            if (nums[i] != nums[correctIndex]) {
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else {
                i++;
            }
        }

        for (int j = 0; j < n; j++) {
            if (nums[j] != j + 1) {
                return nums[j];
            }
        }

        return -1;
    }

    public int findDuplicateUsingSorting(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return -1;
    }



}