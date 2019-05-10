package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DFSTraversal {

	public static void main(String[] args) {
		Graph graph = createGraph();
		int start = 2;
		List<Integer> result = dfsRecursive(graph, start);
		System.out.println(result);
		
		result = dfsIterative(graph, start);
		System.out.println(result);
	}
	
	private static List<Integer> dfsIterative(Graph graph, int start) {
		
		boolean visited[] = new boolean[graph.size()];
		List<Integer> result = new ArrayList<>();
		
		Stack<Integer> stack = new Stack<>();
		stack.push(start);
		
		while(!stack.isEmpty()) {
			int current = stack.pop();
			result.add(current);
			
			if(!visited[current]) 
				visited[current] = true;
			
			for(int neighbor: graph.getNeighbors(current)) {
				if(!visited[neighbor])
					stack.push(neighbor);
			}
		}
		
		return result;
	}

	private static List<Integer> dfsRecursive(Graph graph, int start) {
		boolean visited[] = new boolean[graph.size()];
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
		List<int[]> edges = new ArrayList<>();
		edges.addAll(Arrays.asList(
				new int[] {0, 2},
				new int[] {0, 1},
				new int[] {1, 2},
				new int[] {2, 0},
				new int[] {2, 3}
			));
		
		graph.addEdges(edges);
		return graph;
	}

}
