package com.prasad.arraysiii;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementIIOptimal {

    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int count1 = 0;
        int element1 = Integer.MIN_VALUE;
        int count2 = 0;
        int element2 = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (count1 == 0 && nums[i] != element2) {
                element1 = nums[i];
                count1 = 1;
            } else if (count2 == 0 && nums[i] != element1) {
                element2 = nums[i];
                count2 = 1;
            } else if (element1 == nums[i]) {
                count1++;
            } else if (element2 == nums[i]) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == element1) {
                count1++;
            }
            if (nums[i] == element2) {
                count2++;
            }
        }
        List<Integer> majorityElements = new ArrayList<>();
        if (count1 > n / 3) {
            majorityElements.add(element1);
        }
        if (count2 > n / 3) {
            majorityElements.add(element2);
        }

        return majorityElements;
    }

}
