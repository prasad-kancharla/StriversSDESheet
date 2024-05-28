package com.prasad.companies.amazon;

public class UpdatePrice {

    public static void main(String[] args) {
        String input = "This sweater cost $40 dollars";
        int price = extractPrice(input);
        input = input.replace(String.valueOf(price), String.valueOf(0.8 * price));
        System.out.println(input);
    }

    public static int extractPrice(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        int n = input.length();
        for (int i = 0; i < n; i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) stringBuilder.append(c);
        }
        return Integer.parseInt(stringBuilder.toString());
    }

}
