package com.demo.caching.algorithms;

import com.demo.caching.ExternalDataStore;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Evicts the most recently put data
 */
public class LIFOCache implements CacheInterface {

    private ExternalDataStore externalDataStore;
    private Map<Integer, String> cache;
    private int maxCacheSize;
    private int cacheMissCount;

    public LIFOCache(ExternalDataStore externalDataStore, int maxCacheSize) {
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
                    // Evict last data
                    AtomicInteger key = new AtomicInteger();
                    cache.keySet().forEach(key::set);
                    cache.remove(key.get());
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
        return cache.keySet().toString();
    }
}
