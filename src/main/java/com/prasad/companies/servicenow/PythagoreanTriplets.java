package com.prasad.companies.servicenow;

import java.util.*;

public class PythagoreanTriplets {

    public static boolean check(int[] arr) {
        int n = arr.length;
        HashMap<Long, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hashMap.put((long) arr[i] * (long) arr[i], i);
        }
        for (int i = 0; i < n; i++) {
            if (pairSum((long) arr[i] * (long) arr[i], i, hashMap)) {
                return true;
            }
        }
        return false;
    }

    private static boolean pairSum(long target, int i, HashMap<Long, Integer> hashMap) {
        for (Map.Entry<Long, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() != i) {
                long num1 = entry.getKey();
                if (hashMap.containsKey(target - num1)) {
                    return true;
                }
            }
        }
        return false;
    }

}
