package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinNumberOfEdgesBetweenTwoNodes {

	public static void main(String[] args) {
		Graph graph = createGraph();
		int start = 1, end = 5;
		int result = countMinEdge(graph, start, end);
		System.out.println(result);
	}

	private static int countMinEdge(Graph graph, int start, int end) {
		int n = graph.size();
		boolean[] visited = new boolean[n];
		int[] distance = new int[n];
		List<Integer> list = new ArrayList<>();
		list.add(start);
		visited[start] = true;
		
		while(list.size() > 0) {
			int current = list.remove(0);
			
			for(int neighbor: graph.getNeighbors(current)) {
				if(!visited[neighbor]) {
					visited[neighbor] = true;
					distance[neighbor] = distance[current] + 1;
					list.add(neighbor);
					
					if(neighbor == end) {
						return distance[neighbor];
					}
				}
			}
		}
		
		return -1;
	}

	private static Graph createGraph() {
		Graph g = new Graph(7);
        List<int[]> edges = new ArrayList<>();
        edges.addAll(Arrays.asList(
                new int[] {0, 1},
                new int[] {0, 2},
                new int[] {0, 4},
                new int[] {1, 2},
                new int[] {2, 5},
                new int[] {3, 4},
                new int[] {4, 5},
                new int[] {4, 6}
            ));
        g.addUndirectedEdges(edges);
        return g;
	}

}
