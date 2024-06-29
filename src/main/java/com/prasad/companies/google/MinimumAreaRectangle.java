package com.prasad.companies.google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/minimum-area-rectangle/description/
class MinimumAreaRectangle {

    public int minAreaRect(int[][] points) {
        int n = points.length;
        HashMap<Integer, Set<Integer>> hashMap = new HashMap<>();
        for (int[] point : points) {
            int key = point[0];
            if (!hashMap.containsKey(key)) {
                hashMap.put(key, new HashSet<>());
            }
            hashMap.get(key).add(point[1]);
        }
        int minArea = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];

                if (x1 != x2 && y1 != y2) {
                    if (hashMap.get(x2).contains(y1) && hashMap.get(x1).contains(y2)) {
                        int area = Math.abs(x1 - x2) * Math.abs(y1 - y2);
                        minArea = Math.min(area, minArea);
                    }
                }
            }
        }
        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }

}