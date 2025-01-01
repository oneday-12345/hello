package com.world.lru;

import java.util.HashMap;
import java.util.Map;

class LRUCacheNode<K, V> {
    K key;
    V value;

    LRUCacheNode<K, V> prev;
    LRUCacheNode<K, V> next;

    public LRUCacheNode(K key, V valule) {
        this.key = key;
        this.value = valule;
        prev = null;
        next = null;
    }
}

public class LRUCache<K, V> {

    LRUCacheNode<K, V> head;
    LRUCacheNode<K, V> tail;

    Map<K, LRUCacheNode<K, V>> map;

    int capacity;

    public LRUCache(int capacity) {
        head = null;
        tail = null;
        map = new HashMap<>();
        this.capacity = capacity;
    }

    // 双向连表，4条链接
    void remove(LRUCacheNode<K, V> node) {

        // node.prev, node, node.next
        if (node.prev != null) {
            node.prev.next = node.next; // 链接(1)
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev; // 链接(3)
        } else {
            tail = node.prev;
        }

        node.prev = null; // 链接(2)
        node.next = null; // 链接(4)
    }

    // 双向连表，4条链接
    void insertHead(LRUCacheNode<K, V> node) {
        // node, head
        node.prev = null; // 链接(3)
        node.next = head; // 链接(2)
        if (head != null) {
            head.prev = node; // 链接(1)
        }
        head = node;

        if (tail == null) {
            tail = node;
        }
    }

    void put(K key, V value) {
        if (map.containsKey(key)) {
            LRUCacheNode<K, V> node = map.get(key);
            node.value = value;

            remove(node);
            insertHead(node);

            map.put(key, node);
        } else {
            if (map.size() >= capacity) {
                LRUCacheNode<K, V> node = tail;
                remove(node);
                map.remove(node.key);
            }
            LRUCacheNode<K, V> newNode = new LRUCacheNode<>(key, value);
            insertHead(newNode);
            map.put(key, newNode);
        }
    }

    LRUCacheNode<K, V> get(K key) {
        if (!map.containsKey(key)) {
            return null;
        }
        LRUCacheNode<K, V> node = map.get(key);
        remove(node);
        insertHead(node);

        return node;
    }

}
