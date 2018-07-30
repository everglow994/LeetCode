package Heap;

import java.util.HashMap;

public class LRUCacheSingly {
    /*
     * @param capacity: An integer
     */

    private class Node {
        int key, value;
        Node next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private HashMap<Integer, Node> map;
    private Node head = new Node(-1, -1);
    private Node tail;
    private int capacity;


    LRUCacheSingly(int capacity) {
        map = new HashMap<>();
        tail = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }

        moveToTail(key);
        return tail.value;
    }

    public void set(int key, int value) {
        if(map.containsKey(key)) {
            moveToTail(key);
            tail.value = value;
            return;
        }

        if(map.size() == capacity) {
            map.remove(head.next.key);
            if(map.size() != 0) {
                head.next = head.next.next;
                map.put(head.next.key, head);
            }
        }

        Node insert = new Node(key, value);
        tail.next = insert;
        map.put(key, tail);
        tail = insert;
    }

    public void moveToTail(int key) {
        Node prev = map.get(key);
        Node real = prev.next;

        if(real == tail) return;

        prev.next = real.next;
        map.put(prev.next.key, prev);

        tail.next = real;
        map.put(key, tail);
        tail = real;
    }
}