package com.prasad.companies.google;

import java.util.Map;
import java.util.TreeMap;

// https://leetcode.com/problems/odd-even-jump/description/
// https://leetcode.com/problems/odd-even-jump/solutions/217981/java-c-python-dp-using-map-or-stack
class OddEvenJump {

    public int oddEvenJumps(int[] arr) {
        int goodStartingIndexesCount = 1;
        int length = arr.length;
        boolean[] higher = new boolean[length];
        boolean[] lower = new boolean[length];
        higher[length - 1] = true;
        lower[length - 1] = true;

        TreeMap<Integer, Integer> treeMap = new TreeMap<>(); // element of array and index
        treeMap.put(arr[length - 1], length - 1);

        for (int i = length - 2; i >= 0; i--) {
            Map.Entry<Integer, Integer> higherKeyValuePair = treeMap.ceilingEntry(arr[i]);
            Map.Entry<Integer, Integer> lowerKeyValuePair = treeMap.floorEntry(arr[i]);
            if (higherKeyValuePair != null) {
                higher[i] = lower[higherKeyValuePair.getValue()];
            }
            if (lowerKeyValuePair != null) {
                lower[i] = higher[lowerKeyValuePair.getValue()];
            }
            if (higher[i]) {
                goodStartingIndexesCount++;
            }
            treeMap.put(arr[i], i);
        }
        return goodStartingIndexesCount;
    }

}