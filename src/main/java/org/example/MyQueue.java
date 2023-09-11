package org.example;

public class MyQueue<T> {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        T value;
        Node next;

        Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public MyQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T value) {
        if (head == null) {
            head = new Node(value, null);
            tail = head;
        } else {
            tail.next = new Node(value, null);
            tail = tail.next;
        }
        size++;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (head == null) {
            return null;
        }
        return head.value;
    }

    public T poll() {
        if (head == null) {
            return null;
        }
        T value = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return value;
    }
}