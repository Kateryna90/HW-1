package org.example;

public class MyStack<T> {
    private Node head;
    private int size;

    private class Node {
        T value;
        Node next;

        Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public MyStack() {
        head = null;
        size = 0;
    }

    public void push(T value) {
        head = new Node(value, head);
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            head = head.next;
        } else {
            Node current = getNode(index - 1);
            current.next = current.next.next;
        }
        size--;
    }

    public void clear() {
        head = null;
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

    public T pop() {
        if (head == null) {
            return null;
        }
        T value = head.value;
        head = head.next;
        size--;
        return value;
    }

    private Node getNode(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
}

