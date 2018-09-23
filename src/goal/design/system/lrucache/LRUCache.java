package goal.design.system.lrucache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    int capacity;
    Map<Integer, Node> map = new HashMap<Integer, Node>();
    Node head;
    Node end;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public String get(int key) {

        if (map.containsKey(key)) {
            Node n = map.get(key);
            if (n.prev != null) {
                remove(n);
                setHead(n);
            }
            return n.value;
        }
        return null;
    }

    private void setHead(Node n) {
        if (head != null) {
            head.prev = n;
        }
        n.next = head;
        n.prev = null;
        head = n;

        if (end == null) {
            end = head;
        }
    }

    public void remove(Node n) {
        if (n.next != null) {
            if(n.prev != null) 
            	n.prev.next = n.next;
            n.next.prev = n.prev;

            n.next = null;
            n.prev = null;
        } else {
        	if(n.prev != null) 
        		n.prev.next = null;
        	end = n.prev;
        	n.prev = null;
        }
    }

    public void set(int key, String value) {
        if (map.containsKey(key)) {
            Node old = map.get(key);
            old.value = value;
            if (old.prev != null) {
                remove(old);
                setHead(old);
            }
        } else {
            Node newNode = new Node(key, value);
            if (map.size() >= capacity) {
                map.remove(end.key);
                remove(end);
            }
            setHead(newNode);
            map.put(key, newNode);
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
