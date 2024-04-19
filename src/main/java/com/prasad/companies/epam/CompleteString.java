package com.prasad.companies.epam;

import java.util.*;

class CompleteString {

    public static void main(String[] args) {
        String[] arr = {"g", "l", "lm", "ga", "lmn", "gaz"};
        System.out.println(completeString(6, arr));
    }

    public static String completeString(int n, String[] a) {
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hashSet.add(a[i]);
        }

        String longCompleteString = "";
        for (int i = 0; i < n; i++) {
            int length = a[i].length();
            boolean isComplete = true;
            for (int j = 1; j <= length; j++) {
                if (!hashSet.contains(a[i].substring(0, j))) {
                    isComplete = false;
                    break;
                }
            }
            if (isComplete && a[i].length() >= longCompleteString.length()) {
                if (a[i].length() == longCompleteString.length()) {
                    if (a[i].compareTo(longCompleteString) < 0) {
                        longCompleteString = a[i];
                    }
                } else {
                    longCompleteString = a[i];
                }
            }
        }
        if (longCompleteString.equals("")) {
            longCompleteString = "None";
        }
        return longCompleteString;
    }

}