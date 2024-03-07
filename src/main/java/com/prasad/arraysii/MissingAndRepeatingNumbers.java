package com.prasad.arraysii;

public class MissingAndRepeatingNumbers {

    public static int[] findMissingRepeatingNumbers(int[] a) {
        int n = a.length;
        int i = 0;

        while (i < n) {
            int correctIndex = a[i] - 1;
            if (a[i] != a[correctIndex]) {
                swap(a, i, correctIndex);
            } else {
                i++;
            }
        }

        int[] missingAndRepeatingNumbers = new int[2];

        for (int j = 0; j < n; j++) {
            if (a[j] != j + 1) {
                missingAndRepeatingNumbers[0] = a[j];
                missingAndRepeatingNumbers[1] = j + 1;
                break;
            }
        }
        return missingAndRepeatingNumbers;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}