package com.demo.caching;

import java.util.LinkedHashMap;

public class LRUCache {

    private LinkedHashMap<Integer, Integer> lhm;

    private final int cacheCapacity;

    public LRUCache(int cacheCapacity) {
        this.lhm = new LinkedHashMap<>(cacheCapacity);
        this.cacheCapacity = cacheCapacity;
    }

    public int get(int key) {
        if (lhm.containsKey(key)) {
            // Move the object to top of LinkedHashMap (since its recently used)
            Integer value = lhm.get(key);
            lhm.remove(key);
            lhm.put(key, value);
            return value;
        } else {
            // If size is full, evict least recently used object and put recent object
            if (this.cacheCapacity == lhm.size()) {
                this.lhm.remove(this.lhm.keySet().stream().findFirst().get());
            }
            // Fetch the resource (can not be simulated here)
            // Store the resource in cache
            this.lhm.put(key, key);

            // return the value
            return key;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.get(2);
        lruCache.get(3);
        lruCache.get(2);
        lruCache.get(4);
        System.out.println(lruCache);
    }

    @Override
    public String toString() {
        return this.lhm.keySet().toString();
    }
}
