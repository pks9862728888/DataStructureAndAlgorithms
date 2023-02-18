package com.demo.caching.algorithms;

import com.demo.caching.ExternalDataStore;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Evicts least recently used data
 */
public class LRUCache implements CacheInterface {

    private ExternalDataStore externalDataStore;
    private Map<Integer, String> cache;
    private int maxCacheSize;
    private int cacheMissCount;

    public LRUCache(ExternalDataStore externalDataStore, int maxCacheSize) {
        this.init(externalDataStore, maxCacheSize);
    }

    @Override
    public void init(ExternalDataStore externalDataStore, int maxCacheSize) {
        this.cache = Collections.synchronizedMap(new LinkedHashMap<>());
        this.externalDataStore = externalDataStore;
        this.maxCacheSize = maxCacheSize;
    }

    @Override
    public String getData(int lookupKey) {
        String data;
        if (cache.containsKey(lookupKey)) {
            // Put current used data in the top of the cache so that it does not get evicted
            data = cache.get(lookupKey);
            synchronized (this) {
                cache.remove(lookupKey);
                cache.put(lookupKey, data);
            }
        } else {
            synchronized (this) {
                this.cacheMissCount++;
                data = externalDataStore.getData(lookupKey);
                if (cache.size() == maxCacheSize) {
                    // Evict first data because least recently used data is in the beginning
                    cache.keySet().stream().findFirst().ifPresent(cache::remove);
                }
                // Put recent data in cache
                cache.put(lookupKey, data);
            }
        }
        return data;
    }

    @Override
    public long getCacheMissCount() {
        return cacheMissCount;
    }

    @Override
    public String getKeysFromCache() {
        List<Integer> list = new ArrayList<>(cache.keySet().size());
        cache.keySet().forEach(k -> list.add(0, k));
        return list.toString();
    }
}
