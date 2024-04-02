package com.prasad.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KthSmallestAndLargest {

	public static void main(String[] args) {
		System.out.println(kthSmallLarge(List.of(2,5,6,7),4,4));
	}
	public static ArrayList<Integer> kthSmallLarge(List<Integer> arr, int n, int k) {
		Collections.sort(arr);
		ArrayList<Integer> ans = new ArrayList<>();
		ans.add(arr.get(k - 1));
		ans.add(arr.get(n - k));
		return ans;
	}
}
