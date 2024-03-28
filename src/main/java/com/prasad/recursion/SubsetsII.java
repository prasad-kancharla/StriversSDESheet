package com.prasad.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SubsetsII {

    public static void main(String[] args) {
        int[] input = {4, 4, 4, 1, 4};
        System.out.println(new SubsetsII().subsetsWithDup(input));
    }

    List<List<Integer>> subsets;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        subsets = new ArrayList<>();
        int n = nums.length;
        List<Integer> subset = new ArrayList<>();
        getSubsets(nums, 0, n, subset);
        return subsets;
    }

    private void getSubsets(int[] nums, int i, int n, List<Integer> subset) {
        if (i == n) {
            subsets.add(new ArrayList<>(subset));
            return;
        }
        // all subsets that include nums[i]
        subset.add(nums[i]);
        getSubsets(nums, i + 1, n, subset);
        subset.remove(subset.size() - 1);

        // all subsets that doesn't include nums[i]
        while (i + 1 < n && nums[i + 1] == nums[i]) {
            i++;
        }
        getSubsets(nums, i + 1, n, subset);
    }

}