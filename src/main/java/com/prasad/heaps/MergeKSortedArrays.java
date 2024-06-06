package com.prasad.heaps;

import java.util.*;
import java.util.ArrayList;

public class MergeKSortedArrays {

	public static void main(String[] args) {
		List<Integer> list1 = List.of(3,5,9);
		List<Integer> list2 = List.of(1,2,3,8);
		List<List<Integer>> input = new ArrayList<>();
		input.add(list1);
		input.add(list2);
		System.out.println(mergeKSortedArrays(input, 2));

	}

    public static ArrayList<Integer> mergeKSortedArrays(List<List<Integer>> kArrays, int k) {
        ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			int n = kArrays.get(i).size();
			for (int j = 0; j < n; j++) {
				list.add(kArrays.get(i).get(j));
			}
		}
		Collections.sort(list);
		return list;
    }

}
