package com.prasad.arraysiii;

import java.util.*;
import java.util.stream.Collectors;

public class MajorityElementII {

    public static void main(String[] args) {
        System.out.println((int)Math.floor(5/3));
    }

    public static List<Integer> majorityElement(int[] v) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int n = v.length;

        List<Integer> majorityElements = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int element = v[i];
            int value = hashMap.containsKey(element) ? hashMap.get(element) + 1 : 1;
            hashMap.put(element, value);

            if (value > n/3) {
                majorityElements.add(element);
            }
        }

        return majorityElements.stream().distinct().collect(Collectors.toList());
    }

}