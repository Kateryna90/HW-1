package org.example;

public class MyArrayList<T> {
    private T[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList () {
        data = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }
    public void add(T value) {
        if (size >= data.length) {
            resize();
        }
        data[size] = value;
        size++;
    }
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }
    public void clear() {
        data = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return data[index];
    }
    private void resize() {
        T[] newData = (T[]) new Object[data.length * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }
}
