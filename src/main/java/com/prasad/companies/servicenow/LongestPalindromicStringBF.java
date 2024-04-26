package com.prasad.companies.servicenow;

public class LongestPalindromicStringBF {

	public static void main(String[] args) {
		System.out.println(longestPalinSubstring("abaaba"));
	}
	public static String longestPalinSubstring(String str) {
		if (str.equals("")) return str;
		String palindrome = str.substring(0,1);
		int palindromeLength = 1;
		int n = str.length();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n + 1; j++) {
				String substring = str.substring(i,j);
				if (isPalindrom(substring) && substring.length() > palindromeLength) {
					palindrome = substring;
					palindromeLength = substring.length();
				}
			}
		}
		return palindrome;
	}

	private static boolean isPalindrom(String string) {
		int n = string.length();
		int i = 0;
		int j = n - 1;

		while (i < j) {
			if (string.charAt(i) != string.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

}
