package com.prasad.strings;

class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strings = {"flower", "flow", "flight"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strings));
    }

    public String longestCommonPrefix(String[] strs) {
        StringBuilder stringBuilder = new StringBuilder();
        int n = strs.length;
        int m = strs[0].length();
        boolean isValid = true;
        for (int i = 0; i < m; i++) {
            if (!isValid) {
                break;
            }
            for (int j = 0; j < n - 1; j++) {
                String s2 = strs[j + 1];
                String s1 = strs[j];
                if (s1.length() <= i || s2.length() <= i || s1.charAt(i) != s2.charAt(i)) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                stringBuilder.append(strs[0].charAt(i));
            }
        }
        return stringBuilder.toString();
    }

}