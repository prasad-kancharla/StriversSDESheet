package com.prasad.companies.google;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/water-and-jug-problem/
// https://www.youtube.com/watch?v=0BgaoIN1VUQ
class WaterAndJugProblem {

    private Set<Integer> seen;

    public boolean canMeasureWater(int x, int y, int target) {
        seen = new HashSet<>();
        return dfs(0, x, y, target);
    }

    private boolean dfs(int totalWater, int x, int y, int target) {
        if (seen.contains(totalWater) || totalWater < 0 || totalWater > (x + y)) {
            return false;
        }
        seen.add(totalWater);
        if (totalWater == target) {
            return true;
        }

        return dfs(totalWater + x, x, y, target) || dfs(totalWater - x, x, y, target)
                || dfs(totalWater + y, x, y, target) || dfs(totalWater - y, x, y, target);
    }

}