package com.demo.caching.algorithms;

import com.demo.caching.ExternalDataStore;

public interface CacheInterface {

    void init(ExternalDataStore externalDataStore, int maxCacheSize);

    String getData(int lookupKey);

    long getCacheMissCount();

    String getKeysFromCache();

    default void printCache() {
        System.out.println(this.getClass().getSimpleName() + " keys: " + getKeysFromCache());
    }
}
