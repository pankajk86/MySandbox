package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
		List<int[]> edges = new ArrayList<>();
        edges.addAll(Arrays.asList(
                new int[] {0, 1},
                new int[] {0, 2},
                new int[] {0, 3},
                new int[] {1, 2},
                new int[] {3, 4}
            ));
        g.addUndirectedEdges(edges);
        return g;
	}

}
