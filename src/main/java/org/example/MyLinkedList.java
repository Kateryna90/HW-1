package org.example;

public class MyLinkedList<T> {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        T value;
        Node next;
        Node prev;

        Node(T value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T value) {
        if (head == null) {
            head = new Node(value, null, null);
            tail = head;
        } else {
            Node newNode = new Node(value, null, tail);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
        } else if (index == size - 1) {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            } else {
                head = null;
            }
        } else {
            Node current = getNode(index);
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        size--;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return getNode(index).value;
    }

    private Node getNode(int index) {
        if (index < size / 2) {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current;
        } else {
            Node current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
            return current;
        }
    }
}
