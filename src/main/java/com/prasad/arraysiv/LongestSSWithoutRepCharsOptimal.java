package com.prasad.arraysiv;

import java.util.HashSet;

class LongestSSWithoutRepCharsOptimal {

    public static void main(String[] args) {
        System.out.println(new LongestSSWithoutRepCharsOptimal().lengthOfLongestSubstring(" "));
    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int i = 0;
        int j = 0;
        int maxLength = 0;
        HashSet<Character> hashSet = new HashSet<>();

        while (i < n && j < n) {
            char ch = s.charAt(j);
            if (!hashSet.contains(ch)) {
                hashSet.add(ch);
            } else {
                while (hashSet.contains(ch)) {
                    hashSet.remove(s.charAt(i));
                    i++;
                }
                hashSet.add(ch);
            }
            j++;
            maxLength = Math.max(maxLength, hashSet.size());
        }
        return maxLength;
    }

}