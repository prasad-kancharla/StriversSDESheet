package com.prasad.companies.amazon;

import java.util.* ;
import java.util.ArrayList;

public class GroupAnagramsTogetherApproach2 {
	public static ArrayList<ArrayList<String>> groupAnagramsTogether(ArrayList<String> strList) {
		int n = strList.size();
		HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			char[] chars = strList.get(i).toCharArray();
			Arrays.sort(chars);
			String key = String.valueOf(chars);
			if (hashMap.containsKey(key)) {
				hashMap.get(key).add(strList.get(i));
			} else {
				ArrayList<String> arrayList = new ArrayList<>();
				arrayList.add(strList.get(i));
				hashMap.put(key, arrayList);
			}
		}
		return new ArrayList<>(hashMap.values());
	}
}