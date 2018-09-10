package graphs;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet {

	private Map<Long, Node> map = new HashMap<>();
	
	/**
	 * Create a node for the given data point.
	 * Initially, each node will be parent of itself.
	 * 
	 * @param data
	 */
	public void makeSet(long data) {
		Node node = new Node(data, 0);
		map.put(data, node);
	}
	
	/**
	 * For a given node, find the set representative (parent).
	 * The parent's parent will be itself.
	 * 
	 * @param node
	 * @return
	 */
	public Node find(Node node) {
		if(node.parent == node)
			return node.parent;
		
		node.parent = find(node.parent);
		return node.parent;
	}
	
	/**
	 * Find the value of the set representative of the set to which
	 * data belongs to.
	 * 
	 * @param data
	 * @return
	 */
	public long find(long data) {
		return find(map.get(data)).data;
	}
	
	/**
	 * Merge two data points into a single set, if they are not
	 * already a part of same set.
	 * 
	 * @param data1
	 * @param data2
	 */
	public void union(long data1, long data2) {
		Node node1 = map.get(data1);
		Node node2 = map.get(data2);
		
		Node parent1 = find(node1);
		Node parent2 = find(node2);
		
		if(parent1.data == parent2.data)
			return;
		
		if(parent1.rank >= parent2.rank) {
			parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank + 1 : parent1.rank;
			parent2.parent = parent1;
		} else {
			parent1.parent = parent2;
		}
	}
	
	public int size() {
		return this.map.size();
	}
}

class Node {
	int rank;
	Node parent;
	long data;
	
	Node(long data, int rank) {
		this.rank = rank;
		this.parent = this;
		this.data = data;
	}
}
