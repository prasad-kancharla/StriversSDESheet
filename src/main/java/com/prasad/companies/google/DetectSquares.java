package com.prasad.companies.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class DetectSquares {

    private HashMap<Integer, List<int[]>> xMap;
    private HashMap<String, Integer> xyMap;

    public DetectSquares() {
        xMap = new HashMap<>();
        xyMap = new HashMap<>();
    }

    public void add(int[] point) {
        int key1 = point[0];
        if (xMap.containsKey(key1)) {
            xMap.get(key1).add(point);
        } else {
            List<int[]> points = new ArrayList<>();
            points.add(point);
            xMap.put(key1, points);
        }

        String key = point[0] + "-" + point[1];
        int value = xyMap.containsKey(key) ? xyMap.get(key) + 1 : 1;
        xyMap.put(key, value);

    }

    public int count(int[] point) {
        int a = point[0];
        int b = point[1];
        int totalSquares = 0;

        List<int[]> pointsWithSameX = xMap.get(a);
        if (pointsWithSameX != null && !pointsWithSameX.isEmpty()) {
            int size = pointsWithSameX.size();
            for (int i = 0; i < size; i++) {
                int c = pointsWithSameX.get(i)[1];
                if (c == b) {
                    continue;
                }
                int distance = Math.abs(c - b);
                int[] dArray = {a + distance, a - distance};

                for (int d : dArray) {
                    String keyOfPoint3 = d + "-" + b;
                    String keyOfPoint4 = d + "-" + c;
                    if (xyMap.containsKey(keyOfPoint3) && xyMap.containsKey(keyOfPoint4)) {
                        totalSquares += (xyMap.get(keyOfPoint3) * xyMap.get(keyOfPoint4));
                    }
                }
            }
        }

        return totalSquares;

    }

}