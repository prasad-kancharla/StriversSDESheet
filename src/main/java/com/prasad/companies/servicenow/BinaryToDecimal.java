package com.prasad.companies.servicenow;

public class BinaryToDecimal {

    public static void main(String[] args) {
        System.out.println(new BinaryToDecimal().getDecimalFromBinary("10011"));
    }

    public int getDecimalFromBinary(String binaryString) {
        int n = binaryString.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (binaryString.charAt(i) == '1') {
                ans += Math.pow(2, n - i - 1);
            }
        }
        return ans;
    }

}
