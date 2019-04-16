package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KruskalMST {

	public static void main(String[] args) {
		WeightedGraph g = createGraph1();
		List<int[]> result = findMST(g);
	}

	private static List<int[]> findMST(WeightedGraph g) {
		List<int[]> sortedWeightedEdges = sort(g);
		
		return null;
	}

	private static List<int[]> sort(WeightedGraph g) {
		List<int[]> result = new ArrayList<>();
		List<int[]>[] adj = g.getAdjacencyList(); // 0: (1, 3), (2, 4)
		
		for(int i = 0; i < adj.length; i++) {
			for(int j = 0; j < adj[i].size(); j++)
				result.add(new int[] {i, adj[i].get(j)[0], adj[i].get(j)[1]});
		}
		
		return null;
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
