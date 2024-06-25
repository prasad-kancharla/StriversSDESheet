package com.prasad.companies.google;

import java.util.HashMap;
import java.util.HashSet;

// https://leetcode.com/problems/logger-rate-limiter/description/
class Logger {

    private HashMap<String, Integer> messageMap;

    public Logger() {
        messageMap = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!messageMap.containsKey(message)) {
            messageMap.put(message, timestamp);
            return true;
        } else if (timestamp - messageMap.get(message) >= 10) {
            messageMap.put(message, timestamp);
            return true;
        }
        return false;
    }

}