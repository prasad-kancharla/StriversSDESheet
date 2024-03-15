package com.prasad.arraysiv;

import java.util.HashMap;

public class LongestSubArrayWithKSumOptimal {

	public static void main(String[] args) {
		int[] input = {1, 0, -1, 1};
		System.out.println(LongestSubsetWithZeroSum(input));
	}

    public static int LongestSubsetWithZeroSum(int []arr) {
        int n = arr.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int sum = 0;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == 0) {
                maxLength = i + 1;
				continue;
            }
            if (hashMap.containsKey(sum)) {
                int length = i - hashMap.get(sum);
                maxLength = Math.max(length, maxLength);
            } else {
                hashMap.put(sum, i);
            }
        }

		return maxLength;
    }

}