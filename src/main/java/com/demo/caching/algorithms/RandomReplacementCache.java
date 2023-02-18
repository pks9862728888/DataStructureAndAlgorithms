package com.demo.caching.algorithms;

import com.demo.caching.ExternalDataStore;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Evicts keys randomly
 */
public class RandomReplacementCache implements CacheInterface {

    private ExternalDataStore externalDataStore;
    private Map<Integer, String> cache;
    private int maxCacheSize;
    private int cacheMissCount;

    public RandomReplacementCache(ExternalDataStore externalDataStore, int maxCacheSize) {
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
                    Random random = new Random();
                    int randomNo = random.nextInt(cache.keySet().size() - 1) + 1;
                    AtomicInteger key = new AtomicInteger(-1);
                    cache.keySet().stream().limit(randomNo).forEach(key::set);
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
