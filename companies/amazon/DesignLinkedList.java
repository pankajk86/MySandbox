package amazon;

public class DesignLinkedList {

	public static void main(String[] args) {
		MyLinkedList mll = new MyLinkedList();
		mll.addAtHead(1);
		mll.addAtIndex(1, 2);
		System.out.println(mll.get(1));
		System.out.println(mll.get(0));
		System.out.println(mll.get(2));
	}

}

class MyLinkedList {
	
	private DLNode head, tail;
	private int size;
	
	/** Initialize your data structure here. */
    public MyLinkedList() {
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
    	DLNode curr = head;
    	for(int i = 0; i < index && index < size; i++)
    		curr = curr.next;
    	
        return curr != null ? curr.val : -1;
    }
    
    /** Add a node of value val before the first element of the linked list. 
     * After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        DLNode node = new DLNode(val);
        if(head != null) {
        	node.next = head;
        	head.prev = node;
        }
        head = node;
        if(tail == null) tail = head;
        
        size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
    	DLNode node = new DLNode(val);
    	if(tail != null) {
    		tail.next = node;
    		node.prev = tail;
    	}
    	tail = node;
    	if(head == null) head = tail;
    	size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. 
     * If index equals to the length of linked list, the node will be appended to the end of linked list. 
     * If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index == 0) addAtHead(val);
        else if(index == size) addAtTail(val);
        else if(index > size) return;
        else {
        	DLNode curr = head;
        	for(int i = 0; i < index - 1; i++)
        		curr = curr.next;
        	
        	DLNode node = new DLNode(val);
        	DLNode next = curr.next;
        	curr.next = node;
        	node.prev = curr;
        	node.next = next;
        	next.prev = node;
        }
        size++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index  > size) return;
        if(index == 0) {
        	head = head.next;
        	head.prev = null;
        } else if(index == size - 1) {
        	tail = tail.prev;
        	tail.next = null;
        } else {
        	DLNode curr = head;
        	for(int i = 0; i < index - 1; i++)
        		curr = curr.next;
        	
        	DLNode next = curr.next;
        	curr.next = next.next;
        	next.prev = curr;
        }
        size--;
    }
}

class DLNode {
	int val;
	DLNode next, prev;
	
	DLNode(int val) {
		this.val = val;
	}
}
