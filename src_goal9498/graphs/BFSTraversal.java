package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BFSTraversal {

	public static void main(String[] args) {
		Graph g = createGraph();
		List<Integer> result = bfs(g);
		System.out.println(result);
	}

	private static List<Integer> bfs(Graph g) {
		List<Integer> result = new ArrayList<>();
		int start = 0, i = 0;
		boolean[] visited = new boolean[g.size()];

		result.add(start);
		visited[start] = true;
		
		while(i < result.size()) {
			int curr = result.get(i);
			
			for(int neighbor: g.getNeighbors(curr)) {
				if(!visited[neighbor]) {
					visited[neighbor] = true;
					result.add(neighbor);
				}
			}
			i++;
		}
		return result;
	}

	private static Graph createGraph() {
		Graph g = new Graph(6);
		List<int[]> edges = new ArrayList<>();
		edges.addAll(Arrays.asList(
				new int[] {0, 1},
				new int[] {0, 5},
				new int[] {1, 5},
				new int[] {1, 2},
				new int[] {2, 3},
				new int[] {2, 4},
				new int[] {2, 5},
				new int[] {3, 4}
			));
		
		g.addUndirectedEdges(edges);
		return g;
	}

}
