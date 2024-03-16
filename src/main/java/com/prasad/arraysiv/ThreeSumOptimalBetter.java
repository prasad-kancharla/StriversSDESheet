package com.prasad.arraysiv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSumOptimalBetter {

    public static void main(String[] args) {
        int[] input = {-2,0,0,2,2};
        System.out.println(new ThreeSumOptimalBetter().threeSum(input));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = n - 1;

            int target = 0 - nums[i];

            while (j < k) {
                int sum = nums[j] + nums[k];
                if (sum < target) {
                    j++;
                } else if (sum > target) {
                    k--;
                } else {
                    List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                    triplets.add(list);
                    j++;
                    k--;
                    while (nums[j] == nums[j - 1]) j++;
                    while (nums[k] == nums[k + 1]) k--;
                }
            }
        }
        return triplets;
    }
}