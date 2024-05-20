package com.prasad.dynamicprogramming;

class LISRecursive {
    public int lengthOfLIS(int[] nums) {
        return getLIS(nums, 0, -1);
    }

    private int getLIS(int[] nums, int index, int prevIndex) {
        if (index == nums.length) {
            return 0;
        }

        int ans1 = getLIS(nums, index + 1, prevIndex);
        int ans2 = 0;
        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            ans2 = 1 + getLIS(nums, index + 1, index);
        }
        return Math.max(ans1, ans2);
    }

}