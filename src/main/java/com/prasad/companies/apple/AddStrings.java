package com.prasad.companies.apple;

public class AddStrings {

    public static void main(String[] args) {
        //		System.out.println((int) '0');
        System.out.println(stringConcatenation("9", "9"));
    }

    public static String stringConcatenation(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();

        StringBuilder sb = new StringBuilder();
        int i = n - 1;
        int j = m - 1;
        int cf = 0;

        while (i >= 0 && j >= 0) {
            int sum = Integer.valueOf(num1.charAt(i)) + Integer.valueOf(num2.charAt(j)) + cf - 96;
            if (sum > 9) {
                sb.append(sum % 10);
                cf = sum / 10;
            } else {
                sb.append(sum);
                cf = 0;
            }
            i--;
            j--;
        }

        while (i >= 0) {
            int sum = Integer.valueOf(num1.charAt(i)) + cf - 48;
            if (sum > 9) {
                sb.append(sum % 10);
                cf = sum / 10;
            } else {
                sb.append(sum);
                cf = 0;
            }
            i--;
        }

        while (j >= 0) {
            int sum = Integer.valueOf(num2.charAt(j)) + cf - 48;
            if (sum > 9) {
                sb.append(sum % 10);
                cf = sum / 10;
            } else {
                sb.append(sum);
                cf = 0;
            }
            j--;
        }

		if (cf != 0) {
			sb.append(cf);
		}
        return sb.reverse().toString();

    }

}
