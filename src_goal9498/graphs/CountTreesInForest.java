package graphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountTreesInForest {

	public static void main(String[] args) {
		int[][] edges = {
				{0, 1}, {0, 2}, {3, 4} // {0, 1}, {1, 2}, {2, 3}, {3, 4}//
		};
		int result = countTreesInForest(edges);
		System.out.println(result);
	}

	private static int countTreesInForest(int[][] edges) {
		Set<Integer> nodes = new HashSet<>();
		Set<Integer> parent = new HashSet<>(); 
		
		for(int[] edge: edges)
			nodes.addAll(Arrays.asList(edge[0], edge[1]));
		
		DisjointSet dset = new DisjointSet();
		for(int node: nodes)
			dset.makeSet(node);
		
		for(int[] edge: edges)
			dset.union(edge[0], edge[1]);
		
		for(int node: nodes)
			parent.add((int)dset.find(node));
		
		return parent.size();
	}

}
