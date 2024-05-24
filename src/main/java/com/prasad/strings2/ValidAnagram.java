package com.prasad.strings2;

class ValidAnagram {

    public static void main(String[] args) {
        System.out.println((int) 'a');
        System.out.println(new ValidAnagram().isAnagram("anagram", "nagaram"));
    }

    public boolean isAnagram(String s, String t) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        int n = s.length();
        int m = t.length();
        if (n != m) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            arr1[(int) s.charAt(i) - 97]++;
            arr2[(int) t.charAt(i) - 97]++;
        }
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

}