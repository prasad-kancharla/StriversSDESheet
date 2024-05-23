package com.prasad.heaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class TopKFrequentElements {

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
        System.out.println(Arrays.toString(new TopKFrequentElements().topKFrequent(arr, 2)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        int[] frequentElements = new int[k];
        int n = nums.length;
        if (n == 0) {
            return frequentElements;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int key = nums[i];
            int value = hashMap.containsKey(key) ? hashMap.get(key) + 1 : 1;
            hashMap.put(key, value);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        for (Map.Entry<Integer, Integer> e : hashMap.entrySet()) {
            maxHeap.offer(e);
        }
        int i = 0;
        while (i < k) {
            frequentElements[i++] = maxHeap.poll().getKey();
        }
        return frequentElements;
    }

}