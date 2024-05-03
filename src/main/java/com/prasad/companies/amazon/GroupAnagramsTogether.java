package com.prasad.companies.amazon;

import java.util.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class GroupAnagramsTogether {

    public static void main(String[] args) {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("abab");
        stringList.add("baba");
        stringList.add("aabb");
        stringList.add("abbc");
    }

    public static ArrayList<ArrayList<String>> groupAnagramsTogether(ArrayList<String> strList) {
        int n = strList.size();
        ArrayList<ArrayList<String>> anagramsGroup = new ArrayList<>();
        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
        int[] charCount;
        for (int i = 0; i < n; i++) {
            charCount = new int[26];
            String string = strList.get(i);
            int m = string.length();
            for (int j = 0; j < m; j++) {
                charCount[string.charAt(j) - 97]++;
            }
            String key = Arrays.toString(charCount);
            if (hashMap.containsKey(key)) {
                hashMap.get(key).add(string);
            } else {
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(string);
                hashMap.put(key, arrayList);
            }
        }
        return (ArrayList<ArrayList<String>>) hashMap.entrySet().stream().map(e -> e.getValue()).collect(Collectors.toList());
    }

}