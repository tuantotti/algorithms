package com.algorithm.trees.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    private Map<Character, TrieNode> children = new HashMap<>();
    private boolean isEndWord;

    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    public void setEndWord(boolean endWord) {
        isEndWord = endWord;
    }

    public boolean isEndWord() {
        return isEndWord;
    }
}
