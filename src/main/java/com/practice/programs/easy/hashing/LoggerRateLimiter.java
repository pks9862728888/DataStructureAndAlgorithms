package com.practice.programs.easy.hashing;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * All requests which came in < timeLimit is considered to be duplicate, hence false
 * TC: O(n), AS: O(1)
 */
public class LoggerRateLimiter {

    private final Map<String, Integer> map;
    private final int timeLimit;

    public LoggerRateLimiter(int timeLimit) {
        this.timeLimit = timeLimit;
        map = new LinkedHashMap(timeLimit) {
            @Override
            protected boolean removeEldestEntry(Map.Entry entry) {
                return size() > timeLimit;
            }
        };
    }

    public boolean messageRequestDecision(int timestamp, String request) {
        int prevTimeStamp = map.getOrDefault(request, -1);
        if (prevTimeStamp == -1 || timestamp - prevTimeStamp >= timeLimit) {
            map.remove(request);
            map.put(request, timestamp);
            return true;
        }
        return false;
    }
}
