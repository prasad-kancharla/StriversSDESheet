package com.prasad.strings;

public class ReverseWordsInaString {

    public static String reverseString(String str) {
        String[] arr = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            stringBuilder.append(arr[i]);
			if (i != 0) {
				stringBuilder.append(" ");
			}
        }
        return stringBuilder.toString();
    }

}
