package graphs;

import java.util.ArrayList;
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
		Graph graph = new Graph(7);
		graph.addUndirectedEdge(1, 0);
		graph.addUndirectedEdge(1, 2);
		graph.addUndirectedEdge(0, 2);
		graph.addUndirectedEdge(0, 4);
		graph.addUndirectedEdge(2, 5);
		graph.addUndirectedEdge(4, 5);
		graph.addUndirectedEdge(4, 6);
		graph.addUndirectedEdge(4, 3);
		
		return graph;
	}

}
