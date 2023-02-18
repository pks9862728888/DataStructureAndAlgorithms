package com.demo.caching;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class ExternalDataStore {

    private final Map<Integer, String> dataStore;

    public ExternalDataStore(int startInclusive, int endExclusive) {
        dataStore = Collections.synchronizedMap(new HashMap<>(endExclusive - startInclusive));
        IntStream.range(startInclusive, endExclusive)
                .parallel()
                .forEach(no -> dataStore.put(no, String.valueOf(no)));
    }

    public synchronized String getData(int lookupKey) {
        return dataStore.get(lookupKey);
    }
}
