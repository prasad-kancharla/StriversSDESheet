package com.prasad.arraysiv;

import java.util.HashMap;

public class TwoSumOptimal {
    public static String read(int n, int []book, int target){
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int firstElement = book[i];
            int secondElement = target - firstElement;
            if (hashMap.containsKey(secondElement) && hashMap.get(secondElement) != i) {
                return "YES";
            }
            hashMap.put(firstElement, i);
        }

        return "NO";
    }
}