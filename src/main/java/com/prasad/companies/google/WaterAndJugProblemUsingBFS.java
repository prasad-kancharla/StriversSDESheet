package com.prasad.companies.google;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class WaterAndJugProblemUsingBFS {

    public boolean canMeasureWater(int x, int y, int target) {
        Set<Integer> seen = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        int[] capacity = {x, -x, y, -y};

        while (!queue.isEmpty()) {
            int currentWater = queue.poll();
            seen.add(currentWater);
            for (int i = 0; i < 4; i++) {
                int totalWater = currentWater + capacity[i];
                if (totalWater == target) {
                    return true;
                }
                if (!seen.contains(totalWater) && totalWater > 0 && totalWater < (x + y)) {
                    queue.offer(totalWater);
                }
            }
        }
        return false;
    }

}