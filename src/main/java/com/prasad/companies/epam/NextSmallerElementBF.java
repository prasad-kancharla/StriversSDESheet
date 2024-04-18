package com.prasad.companies.epam;

import java.util.*;

public class NextSmallerElementBF {

    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> nextSmallerElements = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boolean isNotPresent = true;
            for (int j = i + 1; j < n; j++) {
                if (arr.get(j) < arr.get(i)) {
                    nextSmallerElements.add(arr.get(j));
                    isNotPresent = false;
                    break;
                }
            }
            if (isNotPresent) {
                nextSmallerElements.add(-1);
            }
        }
        return nextSmallerElements;
    }

}