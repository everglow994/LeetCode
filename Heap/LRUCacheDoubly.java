package Heap;

import java.util.HashMap;

public class LRUCacheDoubly {

    /*
     * @param capacity: An integer
     */

    private class Node {
        Node prev;
        Node next;
        int value;
        int key;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> map = new HashMap<>();;
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);

    public LRUCacheDoubly(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    /*
     * @param key: An integer
     * @return: An integer
     */

    public int get(int key) {
        // first rearrange this key to the last, then return its value;
        if(!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;

        rearrange(node);
        return node.value;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        if(get(key) != -1) {
            map.get(key).value = value;
            return;
        }

        if(map.size() == capacity) {
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }

        Node insert = new Node(key, value);
        map.put(key, insert);
        rearrange(insert);
    }

    public void rearrange(Node current) {
        current.prev = tail.prev;
        tail.prev = current;
        current.prev.next = current;
        current.next = tail;
    }
}


