package com.demo.datastructures.hashing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Optional;
import java.util.stream.IntStream;

public class MyHash<T> {

    /**
     * Good practice: Bucket should be a prime number
     */
    private int BUCKET = 7;

    private static class ObjectClass<T> {
        int key;
        T value;

        public ObjectClass(int key, T value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "ObjectClass{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private ArrayList<LinkedList<ObjectClass<T>>> hash;

    public MyHash() {
        initList();
    }

    public MyHash(int BUCKET) {
        this.BUCKET = BUCKET;
        initList();
    }

    private void initList() {
        this.hash = new ArrayList<>();
        IntStream.range(0, BUCKET)
                .forEach(i -> hash.add(new LinkedList<>()));
    }

    public void add(Integer key, T value) {
        int slot = key % BUCKET;
        hash.get(slot).addLast(new ObjectClass<>(key, value));
    }

    public void remove(Integer key) {
        int slot = key % BUCKET;
        LinkedList<ObjectClass<T>> objects = hash.get(slot);
        for (int i = 0; i < objects.size(); i++) {
            ObjectClass<T> toRemove = objects.get(i);
            if (objects.get(i).key == key) {
                objects.remove(toRemove);
                i--;
            }
        }
    }

    public T get(Integer key) {
        int slot = key % BUCKET;
        Optional<ObjectClass<T>> first = hash.get(slot)
                .stream()
                .filter(f -> f.key == key)
                .findFirst();
        if (first.isEmpty()) {
            return null;
        } else {
            return first.get().value;
        }
    }

    public void print() {
        System.out.println(hash);
    }
}
