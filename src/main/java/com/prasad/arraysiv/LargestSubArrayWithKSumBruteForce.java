package com.prasad.arraysiv;

import java.util.* ;

public class LargestSubArrayWithKSumBruteForce {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(56, 0, 97, 0, 98, 0, -83 );
		System.out.println(LongestSubsetWithZeroSum(list));
	}

	public static int LongestSubsetWithZeroSum(List<Integer> arr) {
		int n = arr.size();
		int maxLength = 0;

		for (int i = 0; i < n; i++) {
			int sum = arr.get(i);
			if (sum == 0) {
				int length = 1;
				maxLength = Math.max(length, maxLength);
			}
			for (int j = i + 1; j < n; j++) {
				sum += arr.get(j);
				if (sum == 0) {
					int length = j - i + 1;
					maxLength = Math.max(length, maxLength);
				}
			}
		}

		return maxLength;
	}
}