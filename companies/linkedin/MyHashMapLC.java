package linkedin;

public class MyHashMapLC {

	MapNode[] nodes = new MapNode[10000];
	
	public void put(int key, int value) {
		int i = getIndex(key);
		if(nodes[i] == null)
			nodes[i] = new MapNode(-1, -1);
		MapNode prev = findPrev(nodes[i], key);
		
		if(prev.next == null)
			prev.next = new MapNode(key, value);
		else prev.next.value = value;
	}
	
	public int get(int key) {
		int i = getIndex(key);
		if(nodes[i] == null) return -1;
		
		MapNode prev = findPrev(nodes[i], key);
		return prev.next == null ? -1 : prev.next.value;
	}
	
	public void remove(int key) {
		int i = getIndex(key);
		if(nodes[i] == null) return;
		
		MapNode prev = findPrev(nodes[i], key);
		if(prev == null) return;
		
		prev.next = prev.next.next;
	}
	
	private MapNode findPrev(MapNode bucket, int key) {
		MapNode curr = bucket, prev = null;
		while(curr != null && curr.key != key) {
			prev = curr;
			curr = curr.next;
		}
		return prev;
	}

	private int getIndex(int key) {
		return Integer.hashCode(key) % nodes.length; 
	}
}

class MapNode {
	int key, value;
	MapNode next;
	
	MapNode(int key, int value) {
		this.key = key;
		this.value = value;
	}
}
