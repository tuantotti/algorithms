package com.algorithm.trees.trie;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("Programming");
        trie.insert("is");
        trie.insert("a");
        trie.insert("way");
        trie.insert("of");
        trie.insert("life");

        trie.insert("Perfect");
        trie.insert("dog");
        trie.insert("do");

        System.out.println(trie.contains("is"));
        System.out.println(trie.delete("do"));
        System.out.println(trie.contains("do"));
        System.out.println(trie.delete("Programming"));
    }
}
