package com.prasad.servicenow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test2 {

    public static void main(String[] args) {
        List<String> input = List.of("ball", "all", "call", "bal");
        System.out.println(count(input));

    }

    public static long count(List<String> stringData) {
        int n = stringData.size();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isPalindrome(stringData.get(i), stringData.get(j))) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private static boolean isPalindrome(String s1, String s2) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            if (hashMap.containsKey(s1.charAt(i))) {
                hashMap.put(s1.charAt(i), hashMap.get(s1.charAt(i)) + 1);
            } else {
                hashMap.put(s1.charAt(i), 1);
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            if (hashMap.containsKey(s2.charAt(i))) {
                hashMap.put(s2.charAt(i), hashMap.get(s2.charAt(i)) + 1);
            } else {
                hashMap.put(s2.charAt(i), 1);
            }
        }

        int count = 0;
        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }

}
