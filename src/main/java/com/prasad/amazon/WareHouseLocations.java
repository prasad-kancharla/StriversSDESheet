package com.prasad.amazon;

import java.util.ArrayList;
import java.util.List;

public class WareHouseLocations {

    public List<Integer> getWareHouseLocations(int[] centers, int d) {
        int n = centers.length;
        int minCenter = Integer.MAX_VALUE;
        int maxCenter = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            minCenter = Math.min(centers[i], minCenter);
            maxCenter = Math.max(centers[i], maxCenter);
        }

        minCenter = Math.max(-1000000000, minCenter - d/2);
        maxCenter = Math.min(1000000000, maxCenter + d/2);


        List<Integer> warehouseLocations = new ArrayList<>();
        for (int i = minCenter; i <= maxCenter ; i++) {
            if (getDistance(i,centers, d)) {
                warehouseLocations.add(i);
            }
        }
        return warehouseLocations;
    }

    private boolean getDistance(int i, int[] locations, int d) {
        int distance = 0;
        int n = locations.length;
        for (int j = 0; j < n; j++) {
            distance += 2 * Math.abs(locations[j] - i);
            if (distance > d) {
                return false;
            }
        }
        return true;
    }

}
