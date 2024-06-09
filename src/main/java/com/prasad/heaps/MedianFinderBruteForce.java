package com.prasad.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MedianFinderBruteForce {

    private List<Double> list;

    public MedianFinderBruteForce() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        list.add((double) num);
        Collections.sort(list);
    }

    public double findMedian() {
        int n = list.size();
        if (n % 2 == 0) {
            return (list.get(n / 2) + list.get((n / 2) - 1)) / 2;
        } else {
            return list.get(n / 2);
        }
    }

}