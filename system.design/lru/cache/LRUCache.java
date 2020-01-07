package lru.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    int capacity;
    Map<Integer, Node> map = new HashMap<Integer, Node>();
    Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public String get(int key) {
    	if(map.containsKey(key)) {
            Node node = map.get(key);
            if(node.prev != null) {
                remove(node);
                setHead(node);    
            }
            return node.value;
        }
        return null;
    }
    
    public void set(int key, String value) {
    	if(map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            if(node.prev != null) {
                remove(node);
                setHead(node);
            }
        } else {
            Node newNode = new Node(key, value);
            if(map.size() >= capacity) {
                map.remove(tail.key);
                remove(tail);
            }
            map.put(key, newNode);
            setHead(newNode);
        }
    }

    private void setHead(Node node) {
    	if(head != null)
            head.prev = node;
        
        node.next = head;
        node.prev = null;
        head = node;
        
        if(tail == null) tail = head;
    }

    public void remove(Node node) {
    	if(node.next != null) {
            if(node.prev != null)
                node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = node.prev = null;
        } else {
            if(node.prev != null)
                node.prev.next = null;
            tail = node.prev;
            node.prev = null;
        }
    }

    /*
     * A doubly linked list node
     */
    public static class Node {
        int key;
        String value;
        Node next;
        Node prev;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

}
