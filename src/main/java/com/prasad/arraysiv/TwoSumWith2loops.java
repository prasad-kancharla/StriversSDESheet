package com.prasad.arraysiv;

import java.util.Arrays;
import java.util.HashMap;

class TwoSumWith2loops {

    public static void main(String[] args) {
        int[] input = {3, 2, 4};
        System.out.println(Arrays.toString(new TwoSumWith2loops().twoSum(input, 6)));
    }

    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];

        int n = nums.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hashMap.put(nums[i], i);
        }

        for (int i = 0; i < n; i++) {
            int secondElement = target - nums[i];
            if (hashMap.containsKey(secondElement) && hashMap.get(secondElement) != i) {
                ans[0] = i;
                ans[1] = hashMap.get(secondElement);
            }
        }
        return ans;
    }

}