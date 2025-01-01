package com.world.trie;

import java.util.Map;
import java.util.HashMap;

public class Trie<V> {

    public static class TrieNode<V> {
        V value;
        boolean isLeaf;
        Map<Character, TrieNode<V>> children; // node 才体现出递归

        public TrieNode() {
            this(null, false);
        }

        public TrieNode(V value, boolean isLeaf) {
            this.value = value;
            this.isLeaf = isLeaf;
            this.children = new HashMap<>();
        }
    }

    TrieNode<V> root;

    void insert(String key, V value) {

        TrieNode<V> node = root;

        for (int i = 0; i < key.length(); ++i) {
            char c = key.charAt(i);
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode<V>());
            }
            node = node.children.get(c);
        }
        node.value = value;
        node.isLeaf = true;
    }

    TrieNode<V> search(String key) {
        TrieNode<V> node = root;
        for (int i = 0; i < key.length(); ++i) {
            char c = key.charAt(i);
            if (!node.children.containsKey(c)) {
                return null;
            }
            node = node.children.get(c);
        }
        return node;
    }
}
