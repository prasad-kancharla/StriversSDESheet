package com.prasad.companies.google;

import java.util.HashSet;

class RangeModuleBruteForce {
    private HashSet<Integer> hashSet;

    public RangeModuleBruteForce() {
        hashSet = new HashSet<>();
    }
    
    public void addRange(int left, int right) {
        for (int i = left; i < right; i++) {
            hashSet.add(i);
        }
    }
    
    public boolean queryRange(int left, int right) {
        for (int i = left; i < right; i++) {
            if (!hashSet.contains(i)) {
                return false;
            }
        }
        return true;
    }
    
    public void removeRange(int left, int right) {
        for (int i = left; i < right; i++) {
            hashSet.remove(i);
        }
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */