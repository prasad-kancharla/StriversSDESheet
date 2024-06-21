package com.prasad.companies.salesforce;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeatingCharactersBFOptimal {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aab"));
    }
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int i = 0;
        int j = 0;
        int maxSize = 0;
        Set<Character> hashSet = new HashSet<>();

        while (i < n && j < n) {
            char c = s.charAt(j);
            if (!hashSet.contains(c)) {
                hashSet.add(c);
            } else {
                while (hashSet.contains(c)) {
                    hashSet.remove(s.charAt(i));
                    i++;
                }
                hashSet.add(c);
            }
            maxSize = Math.max(hashSet.size(), maxSize);
            j++;
        }
        return maxSize;
    }
}
