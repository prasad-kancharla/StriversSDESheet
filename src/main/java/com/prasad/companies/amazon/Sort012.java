package com.prasad.companies.amazon;

public class Sort012 {

    public static void sort012(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        int zeroes = 0;
        int ones = 0;
        int twos = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                zeroes++;
            } else if (arr[i] == 1) {
                ones++;
            } else {
                twos++;
            }
        }

        int k = 0;
        while (zeroes > 0) {
            arr[k++] = 0;
            zeroes--;
        }

        while (ones > 0) {
            arr[k++] = 1;
            ones--;
        }

        while (twos > 0) {
            arr[k++] = 2;
            twos--;
        }
    }

}