package com.demo.caching;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
public class LRUCacheLinkedHashMap {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        log.info("Before access: {}", cache);
        cache.get(1);
        log.info("After access: {}", cache);
        cache.put(4, 4); // 2 will be removed because 2 is LRU
        log.info("After removal: {}", cache);
    }

    private static class LRUCache {

        private final int CAPACITY;
        private Map<Integer, Integer> map;

        public LRUCache(int size) {
            CAPACITY = size;
            map = new LinkedHashMap<Integer, Integer>() {
                @Override
                protected boolean removeEldestEntry(Map.Entry<Integer, Integer> entry) {
                    return size() > CAPACITY;
                }
            };
        }

        int get(int key) {
            if (map.containsKey(key)) {
                int value = map.get(key);
                map.remove(key);
                map.put(key, value);
                return value;
            }
            return -1;
        }

        void put(int key, int value) {
            map.put(key, value);
        }
    }
}
