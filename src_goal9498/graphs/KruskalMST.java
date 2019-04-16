package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KruskalMST {

	public static void main(String[] args) {
		WeightedGraph g = createGraph1();
		List<int[]> result = findMST(g);
		
		int mstCost = 0;
		System.out.println("Minimum Spanning Tree Edges:");
		for(int[] edge: result) {
			System.out.print("(" + edge[0] + ", " + edge[1] + ") ");
			mstCost += edge[2];
		}
		
		System.out.println("\nMST Cost: " + mstCost);
	}

	private static List<int[]> findMST(WeightedGraph g) {
		List<int[]> sortedEdges = sort(g);
		Set<Integer> nodes = new HashSet<>();
		nodes.addAll(Arrays.asList(0, 1, 2, 3, 4, 5, 6));
		
		GraphDisjoingSet ds = new GraphDisjoingSet();
		for(int node: nodes)
			ds.makeSet(node);
		
		for(int[] edge: sortedEdges) {
			ds.union(edge[0], edge[1], edge[2]);
		}
		
		return ds.getMST();
	}

	private static List<int[]> sort(WeightedGraph g) {
		List<int[]> edges = new ArrayList<>(g.getEdges());
		Collections.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				if(a[2] < b[2]) return -1;
				else if(a[2] > b[2]) return 1;
				return 0;
			}
		});
		
		return edges;
	}

	private static WeightedGraph createGraph1() {
		WeightedGraph g = new WeightedGraph(7);
		List<int[]> edges = Arrays.asList(
				new int[] {0, 1, 3},
				new int[] {0, 2, 5},
				new int[] {0, 3, 6},
				new int[] {1, 3, 2},
				new int[] {2, 3, 2},
				new int[] {2, 4, 6},
				new int[] {2, 5, 3},
				new int[] {2, 6, 7},
				new int[] {3, 5, 9},
				new int[] {4, 5, 5},
				new int[] {4, 6, 2},
				new int[] {5, 6, 1}
				);
		
		g.addUndirectedEdges(edges);
		return g;
	}
}

class GraphDisjoingSet extends DisjointSet {
	
	List<int[]> mstEdges = new ArrayList<>();
	
	public void union(long data1, long data2, long weight) {
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
		mstEdges.add(new int[] {(int) data1, (int) data2, (int) weight});
	}
	
	public List<int[]> getMST() {
		return this.mstEdges;
	}
}
