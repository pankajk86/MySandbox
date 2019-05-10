package linkedin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GraphValidTree {

	public static void main(String[] args) {
		int n = 5;
		int[][] edges = {{0, 1},{1, 2},{2, 3},{1, 3},{1, 4}};
		boolean result = isGraphValidTree(n, edges);
		System.out.println(result);
	}

	private static boolean isGraphValidTree(int n, int[][] edges) {
		DisjointSet1 dset = new DisjointSet1();
		Set<Integer> rep = new HashSet<>();
		
		for(int i = 0; i < n; i++)
			dset.makeSet(i);
		
		for(int i = 0; i < edges.length; i++) {
			boolean merged = dset.union(edges[i][0], edges[i][1]);
			if(!merged) return false;
		}
		
		for(int i = 0; i < n; i++)
			rep.add(dset.find(i));
		
		return rep.size() == 1 ? true : false;
	}

}

class DisjointSet1 {
	Map<Integer, Node> map = new HashMap<>();
	
	public void makeSet(int data) {
		map.put(data, new Node(data, 0));
	}
	
	public Node find(Node node) {
		if(node.parent == node) return node.parent;
		node.parent = find(node.parent);
		return node.parent;
	}
	
	public int find(int data) {
		return find(map.get(data)).data;
	}
	
	public boolean union(int data1, int data2) {
		Node rep1 = find(map.get(data1)), rep2 = find(map.get(data2));
		
		if(rep1.data == rep2.data) return false;
		
		if(rep1.rank >= rep2.rank) {
			rep1.rank = rep1.rank == rep2.rank ? rep1.rank + 1 : rep1.rank;
			rep2.parent = rep1;
		} else rep1.parent = rep2;
		
		return true;
	}
}

class Node {
	int rank;
	Node parent;
	int data;
	
	Node(int data, int rank) {
		this.rank = rank;
		this.parent = this;
		this.data = data;
	}
}

