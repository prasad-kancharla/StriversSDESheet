package com.prasad.arraysiv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FourSum {

    public static void main(String[] args) {
        int[] input = {1000000000, 1000000000, 1000000000, 1000000000};
        System.out.println(new FourSum().fourSum(input, -294967296));
        //        System.out.println(1000000000 + 1000000000 + 1000000000 + 1000000000);
    }

    List<List<Integer>> quadruplets;

    public List<List<Integer>> fourSum(int[] nums, int target) {
        quadruplets = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> quadruplet = new ArrayList<>();
        getQuadruplets(nums, 4, 0, Long.valueOf(target), quadruplet);
        return quadruplets;
    }

    private void getQuadruplets(int[] nums, int k, int start, long target, List<Integer> quadruplet) {
        int n = nums.length;
        if (k != 2) {
            for (int i = start; i < n - k + 1; i++) {
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                quadruplet.add(nums[i]);
                getQuadruplets(nums, k - 1, i + 1, target - nums[i], quadruplet);
                quadruplet.remove(Integer.valueOf(nums[i]));
            }
        } else {
            int i = start;
            int j = n - 1;

            while (i < j) {
                long sum = (long) nums[i] + (long) nums[j];
                if (sum < target) {
                    i++;
                } else if (sum > target) {
                    j--;
                } else {
                    List<Integer> temp = new ArrayList<>(quadruplet);
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    quadruplets.add(new ArrayList<>(temp));
                    i++;
                    j--;
                    while (i < n && nums[i] == nums[i - 1]) {
                        i++;
                    }
                    while (j >= start && nums[j] == nums[j + 1]) {
                        j--;
                    }
                }
            }
        }
    }

}