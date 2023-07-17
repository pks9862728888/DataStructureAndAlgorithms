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

        private final int MAX_CAPACITY;
        private final LinkedHashMap<Integer, Integer> map;

        LRUCache(int capacity) {
            this.MAX_CAPACITY = capacity;
            this.map = new LinkedHashMap<Integer, Integer>(this.MAX_CAPACITY, 0.75f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                    return size() > MAX_CAPACITY;
                }
            };
        }

        public Integer get(Integer key) {
            return this.map.get(key);
        }

        public void put(Integer key, Integer value) {
            this.map.put(key, value);
        }

        @Override
        public String toString() {
            return this.map.toString();
        }
    }
}
