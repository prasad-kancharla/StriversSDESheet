package com.prasad.companies.salesforce;

import java.util.HashSet;
import java.util.Set;

class LongestSubStringWithoutRepeatingCharactersBF {

    public static void main(String[] args) {
        System.out.println(new LongestSubStringWithoutRepeatingCharactersBF().lengthOfLongestSubstring("jbpnbwwd"));
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> hashSet = new HashSet<>();
        int n = s.length();
        if (n == 1) {
            return 1;
        }
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                if (hashSet.contains(c)) {
                    maxLength = Math.max(hashSet.size(), maxLength);
                    hashSet.clear();
                }
                hashSet.add(c);
            }
            maxLength = Math.max(hashSet.size(), maxLength);
            hashSet.clear();
        }
        return maxLength;
    }

}