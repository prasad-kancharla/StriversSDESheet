package com.prasad.dynamicprogramming;

class MaxProductSubArray {

    public static void main(String[] args) {
        int[] arr = {-4, -3, -2};
        System.out.println(new MaxProductSubArray().maxProduct(arr));
    }

    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int ans = nums[0];
        int currentMin = 1;
        int currentMax = 1;

        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                int temp = currentMax;
                currentMax = Math.max(Math.max(nums[i] * currentMin, nums[i] * currentMax), nums[i]);
                currentMin = Math.min(Math.min(nums[i] * temp, nums[i] * currentMin), nums[i]) ;
                ans = Math.max(currentMax, ans);
            } else {
                ans = Math.max(ans, 0);
                currentMin = 1;
                currentMax = 1;
            }
        }
        return ans;
    }
}