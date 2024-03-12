package com.prasad.arraysiv;

import java.util.HashSet;

class LongestConsecutiveSubsequenceOptimal {

    public static void main(String[] args) {
        int[] input = {100,200,1,3,2,4};
        int[] input2 = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(new LongestConsecutiveSubsequenceOptimal().longestConsecutive(input));
    }
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hashSet.add(nums[i]);
        }

        int maxLength = 1;

        for (Integer i : hashSet) {
            if (!hashSet.contains(i - 1)) {
                int x = i;
                int length = 1;
                while (hashSet.contains(x + 1)) {
                    x = x + 1;
                    length++;
                }
                maxLength = Math.max(length, maxLength);
            }
        }

        return maxLength;
    }
}