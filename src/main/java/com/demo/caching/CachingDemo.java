package com.demo.caching;

import com.demo.caching.algorithms.*;

import java.util.ArrayList;
import java.util.List;

import static com.projects.tictactoe.PrintUtils.printSeparator;

public class CachingDemo {

    private static final int keyStartInclusive = 1;
    private static final int keyEndExclusive = 3;
    private static final int maxCacheSize = 3;

    public static void main(String[] args) {
        ExternalDataStore dataStore = new ExternalDataStore(keyStartInclusive, keyEndExclusive);
        List<Integer> dataLookupKeys = getDataLookupKeysForAlgorithmAnalysis();

        // Print performances of different caching strategies
        // FIFO Cache
        printSeparator();
        printPerformance(new FIFOCache(dataStore, maxCacheSize), dataLookupKeys);

        // LIFO Cache
        printSeparator();
        printPerformance(new LIFOCache(dataStore, maxCacheSize), dataLookupKeys);

        // RandomReplacement Cache
        printSeparator();
        printPerformance(new RandomReplacementCache(dataStore, maxCacheSize), dataLookupKeys);

        // LRU Cache
        printSeparator();
        printPerformance(new LRUCache(dataStore, maxCacheSize), dataLookupKeys);

        // MRU Cache
        printSeparator();
        printPerformance(new MRUCache(dataStore, maxCacheSize), dataLookupKeys);
    }

    private static List<Integer> getDataLookupKeysForAlgorithmAnalysis() {
        List<Integer> lookupKeys = new ArrayList<>();
        lookupKeys.add(1);
        lookupKeys.add(2);
        lookupKeys.add(1);
        lookupKeys.add(3);
        lookupKeys.add(4);
        return lookupKeys;
    }

    private static void printPerformance(CacheInterface cache, List<Integer> dataLookupKeys) {
        // Get data from cache
        dataLookupKeys.forEach(cache::getData);

        // Print cache
        cache.printCache();

        // Get cache miss count
        System.out.printf("%s miss count: %s%n", cache.getClass().getSimpleName(),
                cache.getCacheMissCount());
    }
}
