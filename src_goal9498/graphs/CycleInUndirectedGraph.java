package graphs;

import java.util.Arrays;
import java.util.Stack;

public class CycleInUndirectedGraph {

	public static void main(String[] args) {
		Graph g = createGraph();
		boolean result = checkCycleWithDFS(g);
		System.out.println(result);
	}

	private static boolean checkCycleWithDFS(Graph g) {
		int n = g.size(), start = 1;
		boolean[] visited = new boolean[n];
		int[] parent = new int[n];
		Stack<Integer> stack = new Stack<>();
		
		stack.push(start);
		visited[start] = true;
		Arrays.fill(parent, -1);
		
		while(!stack.isEmpty()) {
			int current = stack.pop();
			for(int neighbor: g.getNeighbors(current)) {
				if(!visited[neighbor]) {
					visited[neighbor] = true;
					parent[neighbor] = current;
					stack.push(neighbor);
				} else {
					if(neighbor != parent[current])
						return true;
				}
			}
		}
		
		return false;
	}

	private static Graph createGraph() {
		
		Graph g = new Graph(5);
		
		g.addUndirectedEdge(0, 1);
		g.addUndirectedEdge(1, 2);
		g.addUndirectedEdge(0, 2);
		g.addUndirectedEdge(0, 3);
		g.addUndirectedEdge(3, 4);
		
		return g;
	}

}
