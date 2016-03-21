package goal.algorithms.graphs;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class GraphTest {

	public static void main(String[] args) {

		Graph<Integer> graph = new Graph<Integer>();

		Vertex<Integer> A = new Vertex<Integer>(1);
		Vertex<Integer> B = new Vertex<Integer>(2);
		Vertex<Integer> C = new Vertex<Integer>(3);

		graph.addEdge(A, B);
		graph.addEdge(B, C);
		graph.addEdge(C, A);

		testAddEdge(graph);

	}

	private static void testAddEdge(Graph<Integer> graph) {
		Map<Vertex<Integer>, List<Edge<Integer>>> adjMap = graph.getAdjMap();

		for (Entry<Vertex<Integer>, List<Edge<Integer>>> entry : adjMap.entrySet()) {

			System.out.println("Vertex: " + entry.getKey().getId());

			for (Edge<Integer> edge : entry.getValue()) {
				System.out.println(edge.getStart().getId() + "==" + edge.getEnd().getId());
			}
		}
	}

}
