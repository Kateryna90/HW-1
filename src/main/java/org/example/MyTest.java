package org.example;

public class MyTest {
    public static void main(String[] args) {
        /* MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.size());
        System.out.println(list.get(1));
        list.remove(1);
        System.out.println(list.size());
        System.out.println(list.get(1));
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.size());
        System.out.println(list.get(1));
        list.remove(1);
        System.out.println(list.size());
        System.out.println(list.get(1));
        MyQueue<Integer> queue = new MyQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.size());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.size());
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.size());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.size()); */
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        System.out.println(map.size());
        System.out.println(map.get("two"));
        map.remove("two");
        System.out.println(map.size());
        System.out.println(map.get("two"));

    }

}

