package com.prasad.arraysiii;

public class MajorityElementOptimal {

    public static int majorityElement(int[] v) {
        int n = v.length;

        int count = 0;
        int element = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (count == 0) {
                element = v[i];
                count = 1;
            } else if (element == v[i]) {
                count++;
            } else {
                count--;
            }
        }

        // the below for loop check is needed if question says the input might not have majority element
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            if (v[i] == element) {
                maxCount++;
            }
        }
        if (maxCount > n/2) {
            return element;
        }
        return -1;
    }

}