package com.prasad.arraysiv;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class LongestConsecutiveSubsequence {

    public static void main(String[] args) {
        int[] input = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(new LongestConsecutiveSubsequence().longestConsecutive(input));
    }
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(nums[i]);
        }
        list = list.stream().sorted().distinct().collect(Collectors.toList());
        int size = list.size();
        int maxCount = 1;

        int previous = list.get(0);
        int count = 1;
        for (int i = 1; i < size; i++) {
            if (list.get(i) == previous + 1) {
                count++;
            } else {
                count = 1;
            }
            previous = list.get(i);
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }
}