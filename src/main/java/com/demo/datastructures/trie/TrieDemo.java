package com.demo.datastructures.trie;

public class TrieDemo {

    public static void main(String[] args) {
        Trie ob = new Trie();
        ob.add("Hello");
        ob.add("Hell");
        System.out.println("COUNT: " + ob.countWords());
        System.out.println("Hello ? " + ob.search("Hello"));
        System.out.println("Hell ? " + ob.search("Hell"));
        System.out.println("He ? " + ob.search("He"));
        ob.remove("Hell");
        System.out.println("Removed Hell");
        System.out.println("Hell ? " + ob.search("Hell"));
        System.out.println("COUNT: " + ob.countWords());
    }
}
