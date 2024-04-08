package com.prasad.newrelic;

import java.util.ArrayList;
import java.util.List;

public class LongEncodedString {

    public static void main(String[] args) {
        System.out.println(frequency("1(59)2(37)"));
    }
    public static List<Integer> frequency(String s) {
        int n = s.length();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            ans.add(0);
        }

        int i = 0;

        while (i < n) {
            if (s.charAt(i + 2) == '#') {
                int index = Integer.parseInt(s.substring(i, i + 2)) - 1;
                int count = 1;
                if (i + 3 < n && s.charAt(i + 3) == '(') {
                    int endIndex = s.indexOf(")", i + 3);
                    count = Integer.parseInt(s.substring(i + 4, endIndex));
                    i = endIndex + 1;
                } else {
                    i = i + 3;
                }
                ans.set(index, ans.get(index) + count);
            } else if (i + 1 < n && s.charAt(i + 1 ) == '(') {
                int endIndex = s.indexOf(")", i + 1);
                int count = Integer.parseInt(s.substring(i + 2, endIndex));
                int index = Integer.valueOf(s.substring(i, i + 1)) - 1;
                ans.set(index, ans.get(index) + count);
                i = endIndex + 1;
            } else {
                System.out.println("error here 4");
                int index = Integer.valueOf(s.substring(i, i + 1)) - 1;
                ans.set(index, ans.get(index) + 1);
                i = i + 1;
            }
        }

        return ans;
    }
}
