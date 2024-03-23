package com.prasad.linkedlistandarrays;

class MaxConsecutiveOnesLeetCode {

    public static void main(String[] args) {
        int[] input = {1,0,1,1,0,1};
        System.out.println(new MaxConsecutiveOnesLeetCode().findMaxConsecutiveOnes(input));
    }
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxLength = 0;
        int n = nums.length;
        int length = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                length++;
                maxLength = Math.max(length, maxLength);
            } else {
                length = 0;
            }
        }
        return maxLength;
    }
}