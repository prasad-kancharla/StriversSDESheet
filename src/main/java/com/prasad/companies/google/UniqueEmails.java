package com.prasad.companies.google;

import java.util.HashSet;

class UniqueEmails {

    public static void main(String[] args) {
        String[] input = {"test.email+alex@leetcode.com", "test.email@leetcode.com"};
        System.out.println(new UniqueEmails().numUniqueEmails(input));
    }

    public int numUniqueEmails(String[] emails) {
        HashSet<String> uniqueEmails = new HashSet();
        int n = emails.length;
        for (int i = 0; i < n; i++) {
            int size = emails[i].length();
            boolean foundPlus = false;
            StringBuilder tempEmail = new StringBuilder();
            for (int j = 0; j < size; j++) {
                char currentChar = emails[i].charAt(j);
                if (currentChar == '.' || (foundPlus && currentChar != '@')) {
                    continue;
                } else if (currentChar == '@') {
                    tempEmail.append(emails[i].substring(j, size));
                    break;
                } else if (currentChar == '+') {
                    foundPlus = true;
                } else {
                    tempEmail.append(currentChar);
                }
            }
            uniqueEmails.add(tempEmail.toString());
            tempEmail.setLength(0);
        }
        return uniqueEmails.size();
    }

}