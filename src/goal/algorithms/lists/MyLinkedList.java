package goal.algorithms.lists;

public class MyLinkedList {

	private Node head;
	private static int count;
	
	public MyLinkedList() {
		this.head = null;
		MyLinkedList.count = 0;
	}
	
	/**
	 * @return the size of the list
	 */
	public int size() {
		return count;
	}
	
	/**
	 * Adds a new node in the list with "value".
	 * 
	 * @param value
	 */
	public void add(Object value) {
		Node node = new Node(value);
		
		// if head is null, it means the list is empty; we will set head with "node".
		if(head == null) {
			head = node;
		} 
		// if head is not null, we will set "node" as the next node of the last node in the list.
		else {
			Node current = head;
			// if list has only one node
			if (current != null && current.getNext() == null) {
				current.setNext(node);
			} else {
				// traverse till the end of the list
				while (current.getNext() != null) {
					current = current.getNext();
				}
				current.setNext(node);
			}
		}
		
		count++;
	}
	
	/**
	 * Removes the node containing "value" from the list.
	 * 
	 * @param value
	 */
	public void remove(Object value) {
		
		Node parent = null, current = head;
		
		if(current == null) {
			return;
		}
		
		while(current.getData() != value) {
			// we have reached till the end of the list, and haven't found the "value".
			if(current.getNext() == null) {
				return;
			}
			parent = current;
			current = current.getNext();
		}
		
		// head is the node containing "value".
		if(parent==null) {
			head = current.getNext();
		} 
		// "value" is stored in the last node of the list.
		else if(current.getNext() == null) {
			current = null;
			parent.setNext(null);
		} 
		// "value" is stored in any of the middle nodes.
		else {
			parent.setNext(current.getNext());
		}
		
		count--;
	}
	
	/**
	 * Returns the data stored at the provided index in the list.
	 * 
	 * @param index
	 * @return
	 */
	public Object get(int index) {
		Node current = head;
		
		if(index >= count || index < 0) {
			return null;
		}
		
		for(int i=0; i< index; i++) {
			current = current.getNext();
		}
		
		return current.getData();
	}
}

/**
 *
 */
class Node {
	private Object data;
	private Node next;
	
	public Node(Object data) {
		this.data = data;
		this.next = null;
	}
	
	public Object getData() {
		return data;
	}

	public Node getNext() {
		return next;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	
}