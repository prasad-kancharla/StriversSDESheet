package com.prasad.companies.servicenow;

public class LongestPalindromicSubString {

    public static String longestPalinSubstring(String str) {
        int n = str.length();

        if (n <= 1) {
            return str;
        }
        String palindrome = str.substring(0, 1);
        int maxLength = 1;
        for (int i = 0; i < n; i++) {
            int[] arr1 = expandFromMiddle(str, i, i);
            if (arr1[1] - arr1[0] + 1 > maxLength) {
                maxLength = arr1[1] - arr1[0] + 1;
                palindrome = str.substring(arr1[0], arr1[1] + 1);
            }
            int[] arr2 = expandFromMiddle(str, i, i + 1);
            if (arr2[1] - arr2[0] + 1 > maxLength) {
                maxLength = arr2[1] - arr2[0] + 1;
                palindrome = str.substring(arr2[0], arr2[1] + 1);
            }

        }
        return palindrome;
    }

    private static int[] expandFromMiddle(String string, int left, int right) {
        int[] arr = new int[2];
        int n = string.length();
        while (left <= right && left >= 0 && right < n && string.charAt(left) == string.charAt(right)) {
            arr[0] = left;
            arr[1] = right;
            left--;
            right++;
        }
        return arr;
    }

}
