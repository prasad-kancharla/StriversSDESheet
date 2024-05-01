package com.prasad.companies.amazon;

import java.util.ArrayList;

public class findDuplicate {

	public static int findDuplicate(ArrayList<Integer> arr) {

		int n = arr.size();
		for (int i = 0; i < n; i++) {
			while (arr.get(i) - 1 != i) {
				int correctIndex = arr.get(i) - 1;
				if (arr.get(i).equals(arr.get(correctIndex))) return arr.get(i);
				int temp = arr.get(correctIndex);
				arr.set(correctIndex, arr.get(i));
				arr.set(i, temp);
			}
		}
		return -1;
	}
}