package com.prasad;

public class Test {
    static String ans;
    public static String getSmallestString(String word, String substr) {
        ans = "";
        if (word.contains(substr)) {
            word = word.replace('?', 'a');
            return word;
        } else {
            fillString(word.toCharArray(), 0, substr);
        }

        return ans.equals("") ? "-1" : ans;
    }

    private static void fillString(char[] arr, int i, String substr) {
        if (i >= arr.length) {
            return;
        }
        String currenString = String.valueOf(arr);
        if (currenString.contains(substr)) {
            if (ans.equals("") || currenString.compareTo(ans) < 0) {
                ans = currenString;
            }
            return;
        }

        if (arr[i] != '?') {
            for (int k = 0; k < 26; k++) {
                arr[i] = (char) (k + 97);
                fillString(arr, i + 1, substr);
                arr[i] = '?';
            }
        } else {
            fillString(arr, i + 1, substr);
        }
    }
}
