package com.demo.datastructures.java.map;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.IntStream;

public class CustomHashMap<K, V> {

    private double loadFactor;
    private ArrayList<HashNode<K, V>> bucket;
    private int size;
    private int bucketSize;
    public CustomHashMap() {
        bucket = new ArrayList<>();
        IntStream.range(0, 5)
                .forEach(e -> bucket.add(null));
        this.loadFactor = 0.75;
        this.size = 0;
        this.bucketSize = bucket.size();
    }

    public CustomHashMap(double loadFactor) {
        this();
        this.loadFactor = loadFactor;
    }

    private int getIdxFromHashFunction(K key) {
        if (Objects.isNull(key)) {
            return 0;
        }
        return key.hashCode() % bucketSize;
    }

    public void put(K key, V value) {
        int idx = getIdxFromHashFunction(key);
        HashNode<K, V> node = new HashNode<>(key, value);
        if (bucket.get(idx) == null) {
            bucket.set(idx, node);
            size++;
        } else {
            HashNode<K, V> curr = bucket.get(idx);
            boolean found = false;
            while (curr != null) {
                if (curr.key.equals(key)) {
                    curr.value = value;
                    found = true;
                    break;
                }
                curr = curr.next;
            }
            if (!found) {
                node.next = bucket.get(idx);
                bucket.set(idx, node);
                size++;
            }
        }
        rehashIfExceedsLoadFactor();
    }

    private void rehashIfExceedsLoadFactor() {
        if (this.getCurrentLoadFactor() > loadFactor) {
            this.bucketSize *= 2;
            loadFactor = size * 0.1 / bucketSize;
            ArrayList<HashNode<K, V>> newBucket = new ArrayList<>();
            IntStream.range(0, bucketSize + 1)
                    .forEach(value -> newBucket.add(null));
            for (HashNode<K, V> node : bucket) {
                if (Objects.nonNull(node)) {
                    while (node != null) {
                        HashNode<K, V> tempNode = new HashNode<>(node.key, node.value);
                        int idx = getIdxFromHashFunction(node.key);
                        if (Objects.isNull(newBucket.get(idx))) {
                            newBucket.set(idx, tempNode);
                        } else {
                            tempNode.next = newBucket.get(idx);
                            newBucket.set(idx, tempNode);
                        }
                        node = node.next;
                    }
                }
            }

            this.bucket = newBucket;
            System.out.println("Re-hashed!");
        }
    }

    public V get(K key) {
        int idx = getIdxFromHashFunction(key);
        if (idx > bucketSize) {
            throw new NullPointerException("No such key found: " + key);
        }
        HashNode<K, V> curr = bucket.get(idx);
        while (curr != null) {
            if (curr.key.equals(key)) {
                break;
            }
            curr = curr.next;
        }
        if (Objects.isNull(curr)) {
            throw new NullPointerException("No such key found: " + key);
        } else {
            return curr.value;
        }
    }

    public void delete(K key) {
        int idx = getIdxFromHashFunction(key);
        if (idx > bucketSize || Objects.isNull(bucket.get(idx))) {
            return;
        }
        HashNode<K, V> curr = bucket.get(idx);
        HashNode<K, V> prev = null;
        while (curr != null) {
            if (curr.key.equals(key)) {
                if (prev == null) {
                    bucket.set(idx, curr.next);
                    size--;
                    return;
                } else {
                    prev.next = curr.next;
                    size--;
                    return;
                }
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public boolean containsKey(K key) {
        int idx = getIdxFromHashFunction(key);
        if (idx > bucketSize || Objects.isNull(bucket.get(idx))) {
            return false;
        }
        HashNode<K, V> node = bucket.get(idx);
        while (node != null) {
            if (node.key.equals(key)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public double getCurrentLoadFactor() {
        return (double) size / bucketSize;
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (HashNode<K, V> node : bucket) {
            while (node != null) {
                sb.append(node.key).append("=").append(node.value).append(",");
                node = node.next;
            }
        }
        return String.format("CustomHashMap{%s}", sb);
    }

    private class HashNode<S, T> {
        S key;
        T value;
        HashNode<S, T> next;

        public HashNode(S key, T value) {
            this.key = key;
            this.value = value;
        }
    }
}
