package com.prasad.companies.google;

import java.util.Arrays;

// https://leetcode.com/problems/next-closest-time/description/
// https://leetcode.com/problems/next-closest-time/solutions/107773/java-ac-5ms-simple-solution-with-detailed-explaination/
class NextClosestTime {

    public static void main(String[] args) {
        System.out.println(new NextClosestTime().nextClosestTime("12:22"));
    }

    public String nextClosestTime(String time) {
        char[] timeChars = time.toCharArray();
        // convert char to integer by doing - of '0'
        int[] digits = new int[] {timeChars[0] - '0', timeChars[1] - '0', timeChars[3] - '0', timeChars[4] - '0',};
        Arrays.sort(digits);

        timeChars[4] = getDigit(timeChars[4] - '0', 9, digits);
        if (timeChars[4] > time.charAt(4)) {
            return String.valueOf(timeChars);
        }

        timeChars[3] = getDigit(timeChars[3] - '0', 5, digits);
        if (timeChars[3] > time.charAt(3)) {
            return String.valueOf(timeChars);
        }

        timeChars[1] = timeChars[0] == '2' ? getDigit(timeChars[1] - '0', 3, digits) : getDigit(timeChars[1] - '0', 9, digits);
        if (timeChars[1] > time.charAt(1)) {
            return String.valueOf(timeChars);
        }

        timeChars[0] = getDigit(timeChars[0] - '0', 2, digits);
        return String.valueOf(timeChars);
    }

    private char getDigit(int currentDigit, int upperLimit, int[] digits) {
        if (currentDigit >= upperLimit) {
            return (char) (digits[0] + '0');
        }
        int index = Arrays.binarySearch(digits, currentDigit) + 1;
        while (index < 4 && (digits[index] == currentDigit || digits[index] > upperLimit)) {
            index++;
        }
        // convert int to char by doing + '0'
        return index == 4 ? (char) (digits[0] + '0') : (char) (digits[index] + '0');
    }

}