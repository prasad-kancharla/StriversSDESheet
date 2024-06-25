package com.prasad.companies.google;

// https://leetcode.com/problems/license-key-formatting/description/
class LicenseKeyFormatting {

    public static void main(String[] args) {
        System.out.println(new LicenseKeyFormatting().licenseKeyFormatting("5F3Z-2e-9-w", 4));
    }
    public String licenseKeyFormatting(String s, int k) {
        int n = s.length();
        int count = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '-') {
                continue;
            }
            if (count == k) {
                stringBuilder.append('-');
                count = 0;
            }
            stringBuilder.append(c);
            count++;
        }
        return stringBuilder.reverse().toString().toUpperCase();
    }
}