package com.prasad.companies.servicenow;

public class DecimalToBinary {

    public static void main(String[] args) {
        System.out.println(getBinaryString(19));
    }

    public static String getBinaryString(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % 2);
            num = num / 2;
        }
        return sb.reverse().toString();
    }

}
