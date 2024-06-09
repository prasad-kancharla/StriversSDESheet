package com.prasad.strings2;

class CountAndSay {

    public static void main(String[] args) {
        System.out.println(getRLE("1211"));
    }

    public String countAndSay(int n) {
        String prev = "1";
        for (int i = 1; i < n; i++) {
            prev = getRLE(prev);
        }
        return prev;
    }

    public static String getRLE(String s) {
        int n = s.length();
        if (n == 1) {
            return "1" + s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        char prev = s.charAt(0);
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == prev) {
                count++;
            } else {
                stringBuilder.append(count);
                stringBuilder.append(prev);
                count = 1;
                prev = s.charAt(i);
            }
        }
        stringBuilder.append(count);
        stringBuilder.append(prev);
        return stringBuilder.toString();
    }

}