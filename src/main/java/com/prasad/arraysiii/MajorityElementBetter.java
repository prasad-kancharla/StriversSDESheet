package com.prasad.arraysiii;

import java.util.HashMap;
import java.util.Map.Entry;

public class MajorityElementBetter {

    public static void main(String[] args) {
        int[] input = {2,2, 1, 3, 1, 1, 3, 1, 1};
        System.out.println(majorityElement(input));
    }

    public static int majorityElement(int[] v) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int n = v.length;
        for (int i = 0; i < n; i++) {
            if (hashMap.containsKey(v[i])) {
                hashMap.put(v[i], hashMap.get(v[i]) + 1);
            } else {
                hashMap.put(v[i], 1);
            }
        }

        int majorityElement = -1;
        int maxCount = Integer.MIN_VALUE;
        for (Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                majorityElement = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return majorityElement;
    }

}