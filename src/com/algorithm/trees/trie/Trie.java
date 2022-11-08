package com.algorithm.trees.trie;

public class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * The complexity of this operation is O(n) (n represents the key size)
     *
     * @param word the word
     */
    public void insert(String word) {
        TrieNode current = root;

        for (char l : word.toCharArray()) {
            current = current.getChildren().computeIfAbsent(l, c -> new TrieNode());
        }

        current.setEndWord(true);
    }

    /**
     * The complexity of this operation is O(n) (n represents the length of word)
     *
     * @param word the word
     * @return true if this word contains s, false otherwise
     */
    public boolean contains(String word) {
        TrieNode current = root;
        for (char w : word.toCharArray()) {
            TrieNode node = current.getChildren().get(w);
            if (node == null) {
                return false;
            }

            current = node;
        }

        return current.isEndWord();
    }

    /**
     * The complexity of this operation is O(n) (n represents the key size)
     *
     * @param word the word
     * @return true if delete successfully, false otherwise
     */
    public boolean delete(String word) {
        boolean isDeleted = delete(root, word, 0);
        if (!isDeleted && !contains(word)) {
            return true;
        }
        return isDeleted;
    }

    /**
     * @param current the current node
     * @param word    the word to delete
     * @param index   the i character in word
     * @return true if the word is deleted, false otherwise
     */
    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEndWord()) return false;
            current.setEndWord(false);
            return current.getChildren().isEmpty();
        }

        char ch = word.charAt(index);
        TrieNode node = current.getChildren().get(ch);
        if (node == null) {
            return false;
        }

        boolean shouldDeleteNode = delete(node, word, index + 1) && !current.isEndWord();
        // if in trie tree have 'do' and 'dog' for instance--> return false because it do not delete the 'do'
        if (shouldDeleteNode) {
            current.getChildren().remove(ch);
            return current.getChildren().isEmpty();
        }

        return false;
    }
}
