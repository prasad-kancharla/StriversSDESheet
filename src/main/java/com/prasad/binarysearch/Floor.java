package com.prasad.binarysearch;

import java.util.Arrays;

public class Floor {
    public int getFloor(int[] nums, int k) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        int floor = -1;

        while (start <= end) {
            int mid = start + (end - start)/2;
            if (nums[mid] > k) {
                end = mid - 1;
            } else if (nums[mid] < k) {
                floor = nums[mid];
                start = mid + 1;
            } else {
                return nums[mid];
            }
        }
        return floor;
    }
}
