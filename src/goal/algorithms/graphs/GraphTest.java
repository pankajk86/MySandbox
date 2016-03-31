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

        System.out.println("After adding edges: ");
        printGraph(graph);

        graph.deleteEdge(A, B);

        System.out.println("After deleting edge " + A.getId() + "->" + B.getId() + ": ");
        printGraph(graph);
    }

    private static void printGraph(Graph<Integer> graph) {
        Map<Vertex<Integer>, List<Vertex<Integer>>> adjMap = graph.getAdjMap();

        for (Entry<Vertex<Integer>, List<Vertex<Integer>>> entry : adjMap.entrySet()) {
            System.out.print(entry.getKey().getId() + ": ");

            for (Vertex<Integer> vertex : entry.getValue()) {
                System.out.print(vertex.getId() + " ");
            }
            System.out.println();
        }
    }

}
