package com.demo.datastructures.impl.hashing;

public class DemoHashing {

    public static void main(String[] args) {
        MyHash<String> obj = new MyHash<>();
        obj.add(5, "five");
        obj.add(1, "One");
        obj.print();
        obj.remove(5);
        obj.add(15, "Fifteen");
        obj.print();
        System.out.println(obj.get(15));
    }
}
