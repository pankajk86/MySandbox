package graphs;

import java.util.ArrayList;
import java.util.List;

public class DFSTraversal {

	public static void main(String[] args) {
		Graph graph = createGraph();
		int start = 2;
		List<Integer> result = dfs(graph, start);
		System.out.println(result);
	}

	private static List<Integer> dfs(Graph graph, int start) {
		
		boolean visited[] = new boolean[graph.countNodes()];
		List<Integer> result = new ArrayList<>();
		helper(graph, start, result, visited);
		return result;
	}

	private static void helper(Graph graph, int current, List<Integer> result, boolean[] visited) {
		visited[current] = true;
		result.add(current);
		
		for(int neighbor: graph.getNeighbors(current)) {
			if(!visited[neighbor])
				helper(graph, neighbor, result, visited);
		}
	}

	private static Graph createGraph() {

		Graph graph = new Graph(4);
		graph.addEdge(0, 2);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		
		return graph;
	}

}
