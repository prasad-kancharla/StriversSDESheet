package com.prasad.stackandqueue2;

public class NextSmallerElement {
    public static void immediateSmaller(int []a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            if (a[i + 1] < a[i]) {
                a[i] = a[i + 1];
            } else {
                a[i] = -1;
            }
        }
        a[n - 1] = -1;
    }
}
