package com.prasad.companies.google;

import java.util.Map;
import java.util.TreeMap;

class RangeModule {

    TreeMap<Integer, Integer> ranges;

    public RangeModule() {
        ranges = new TreeMap<>();
    }

    public void addRange(int left, int right) {

        Map.Entry<Integer, Integer> start = ranges.floorEntry(left); // left possible overlap entry
        Map.Entry<Integer, Integer> end = ranges.floorEntry(right); // right possible overlap entry

        if (start != null && start.getValue() >= left) {
            left = start.getKey(); // update overlap start
        }
        if (end != null && end.getValue() > right) {
            right = end.getValue(); // update overlap end
        }

        ranges.subMap(left, right).clear();
        ranges.put(left, right);
    }

    public boolean queryRange(int left, int right) {
        Map.Entry<Integer, Integer> start = ranges.floorEntry(left);
        return start != null && start.getValue() >= right; // if there exist a range: start <+ left, end >= right
    }

    public void removeRange(int left, int right) {
        Map.Entry<Integer, Integer> start = ranges.floorEntry(left); // left possible overlap entry
        Map.Entry<Integer, Integer> end = ranges.floorEntry(right); // right possible overlap entry

        if (start != null && start.getValue() > left) {
            ranges.put(start.getKey(), left); // after removal, if anything left
        }
        if (end != null && end.getValue() > right) {
            ranges.put(right, end.getValue()); // after removal, if anything left
        }

        ranges.subMap(left, right).clear();
    }

}