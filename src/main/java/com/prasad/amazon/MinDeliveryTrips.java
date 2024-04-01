package com.prasad.amazon;

import java.util.HashMap;
import java.util.Map;

public class MinDeliveryTrips {

    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 6, 4, 2, 4};
        System.out.println(new MinDeliveryTrips().getMinTrips(nums));
    }

    public int getMinTrips(int[] packages) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int n = packages.length;
        for (int i = 0; i < n; i++) {
            if (hashMap.containsKey(packages[i])) {
                hashMap.put(packages[i], hashMap.get(packages[i]) + 1);
            } else {
                hashMap.put(packages[i], 1);
            }
        }

        int trips = 0;
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            int count = entry.getValue();
            if (count % 3 == 0) {
                trips += count / 3;
            } else if (count % 2 == 0) {
                trips += count / 2;
            } else {
                return -1;
            }
        }
        return trips;
    }

}
