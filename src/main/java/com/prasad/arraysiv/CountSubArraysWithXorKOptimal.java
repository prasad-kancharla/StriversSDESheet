package com.prasad.arraysiv;

import java.util.HashMap;

public class CountSubArraysWithXorKOptimal {
    public static int subarraysWithXorK(int []a, int b) {
       int n = a.length;
       int xor = 0;

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int subArraysCount = 0;

        for (int i = 0; i < n; i++) {
            xor = xor ^ a[i];
            if (xor == b) subArraysCount++;

            if (hashMap.containsKey(xor)) {
                hashMap.put(xor, hashMap.get(xor)  + 1);
            } else {
                hashMap.put(xor, 1);
            }

            // y ^ b = xor; some prev sub array xor ^ b will give current xor - indicates, there is a subarray with xor b in current range
            // y = b ^ xor;
            int y = b ^ xor;
            if (hashMap.containsKey(y)) {
                subArraysCount += hashMap.get(y);
            }
        }
        return subArraysCount;
    }
}