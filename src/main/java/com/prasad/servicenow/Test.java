package com.prasad.servicenow;

public class Test {

    public static void main(String[] args) {
        System.out.println(getAns("abc"));
    }
    public static String getAns(String message) {
        int n = message.length();
        if (n == 0) return message;
        int count = 1;
        char c = message.charAt(0);
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < n; i++) {
            if(message.charAt(i) == c) {
                count++;
            } else {
                sb.append(c);
                if (count > 1) sb.append(count);
                c = message.charAt(i);
                count = 1;
            }
        }

        sb.append(message.charAt(n - 1));
        if(count > 1) {
            sb.append(count);
        }
        return sb.toString();
    }
}
