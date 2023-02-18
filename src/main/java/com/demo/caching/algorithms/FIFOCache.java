package com.demo.caching.algorithms;

import com.demo.caching.ExternalDataStore;

import java.util.*;

/**
 * Evicts the oldest data
 */
public class FIFOCache implements CacheInterface {

    private ExternalDataStore externalDataStore;
    private Map<Integer, String> cache;
    private int maxCacheSize;
    private int cacheMissCount;

    public FIFOCache(ExternalDataStore externalDataStore, int maxCacheSize) {
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
        if (cache.containsKey(lookupKey)) {
            return cache.get(lookupKey);
        } else {
            synchronized (this) {
                this.cacheMissCount++;
                String data = externalDataStore.getData(lookupKey);
                if (cache.size() == maxCacheSize) {
                    // Evict first data
                    cache.keySet().stream()
                            .findFirst()
                            .ifPresent(integer -> cache.remove(integer));
                }
                // Put recent data in cache
                cache.put(lookupKey, data);

                // Return the data
                return data;
            }
        }
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
