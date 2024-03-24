package com.prasad.linkedlistandarrays;

class MaxConsecutiveOnesIII {

    public static void main(String[] args) {
        int[] input = {0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0};
        System.out.println(new MaxConsecutiveOnesIII().longestOnes(input, 3));
    }

    public int longestOnes(int[] nums, int k) {
        int i = 0, j = 0, zeroesCount = 0, maxLen = 0;

        while (j < nums.length) {
            if (nums[j] == 0) {
                zeroesCount++;
            }
            while (zeroesCount > k) {
                if (nums[i] == 0) {
                    zeroesCount--;
                }
                i++;
            }
            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }
        return maxLen;
    }

}