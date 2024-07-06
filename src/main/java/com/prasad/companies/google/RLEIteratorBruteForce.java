package com.prasad.companies.google;

import java.util.ArrayList;
import java.util.List;

class RLEIteratorBruteForce {

    public static void main(String[] args) {
        RLEIteratorBruteForce rleIteratorBruteForce = new RLEIteratorBruteForce(new int[] {3, 8, 0, 9, 2, 5});
        System.out.println(rleIteratorBruteForce.list);
        System.out.println(rleIteratorBruteForce.next(2));
        System.out.println(rleIteratorBruteForce.next(1));
        System.out.println(rleIteratorBruteForce.next(1));
        System.out.println(rleIteratorBruteForce.next(2));

    }

    List<Integer> list;
    private int index;

    public RLEIteratorBruteForce(int[] encoding) {
        list = new ArrayList<>();
        int length = encoding.length;
        for (int i = 0; i < length; i += 2) {
            int count = encoding[i];
            for (int j = 0; j < count; j++) {
                list.add(encoding[i + 1]);
            }
        }
        index = 0;
    }

    public int next(int n) {
        index += n;
        if (index <= list.size()) {
            return list.get(index - 1);
        }
        return -1;
    }

}