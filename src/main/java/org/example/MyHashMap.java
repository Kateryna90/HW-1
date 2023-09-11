package org.example;

public class MyHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;
    private Node<K, V>[] table;
    private int size;

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public MyHashMap() {
        table = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        for (Node<K, V> node = table[index]; node != null; node = node.next) {
            if (key.equals(node.key)) {
                node.value = value;
                return;
            }
        }
        table[index] = new Node<>(key, value, table[index]);
        size++;
        if (size > table.length * LOAD_FACTOR) {
            resize();
        }
    }

    public void remove(K key) {
        int index = getIndex(key);
        Node<K, V> prev = null;
        for (Node<K, V> node = table[index]; node != null; node = node.next) {
            if (key.equals(node.key)) {
                if (prev == null) {
                    table[index] = node.next;
                } else {
                    prev.next = node.next;
                }
                size--;
                return;
            }
            prev = node;
        }
    }

    public void clear() {
        table = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        int index = getIndex(key);
        for (Node<K, V> node = table[index]; node != null; node = node.next) {
            if (key.equals(node.key)) {
                return node.value;
            }
        }
        return null;
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    private void resize() {
        Node<K, V>[] oldTable = table;
        table = new Node[table.length * 2];
        size = 0;
        for (Node<K, V> head : oldTable) {
            for (Node<K, V> node = head; node != null; node = node.next) {
                put(node.key, node.value);
            }
        }
    }
}


