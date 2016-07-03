package goal.phase.two.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArticulationPoints {

    private static List<Vertex> cutVertices = new ArrayList<Vertex>();

    public static void main(String[] args) {

        List<Vertex> graph = getGraphWithSixVertices();
        Vertex start = null;

        for (Vertex v : graph) {
            if (v.id.equals("a")) {
                start = v;
            }
        }

        getArticulationPoints(start, 0);

        for (Vertex v : cutVertices) {
            System.out.print(v.id + " ");
        }

    }

    /**
     * Tarjan's Algorithm : O(E+V)
     * 
     * @param vertex
     * @param depth
     */
    private static void getArticulationPoints(Vertex vertex, int depth) {

        vertex.isVisited = true;
        vertex.depth = depth;
        vertex.low = depth;

        for (Vertex v : vertex.adjVerticesList) {
            if (!v.isVisited) {
                v.parent = vertex;
                getArticulationPoints(v, depth + 1);
                v.childCount += 1;

                if (v.low >= vertex.depth) {
                    vertex.isCutVertex = true;
                }
                vertex.low = Math.min(vertex.low, v.depth);
            } else if (!v.equals(vertex.parent)) {
                vertex.low = Math.min(vertex.low, v.depth);
            }
        }

        if ((vertex.parent != null && vertex.isCutVertex) || (vertex.parent == null && vertex.childCount > 1)) {
            cutVertices.add(vertex);
        }
    }

    /**
     * a        f
     * |\      /|
     * | \    / |
     * b--c--d--e
     * 
     * @return
     */
    private static List<Vertex> getGraphWithSixVertices() {

        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");
        Vertex d = new Vertex("d");
        Vertex e = new Vertex("e");
        Vertex f = new Vertex("f");
        
        a.adjVerticesList.addAll(Arrays.asList(b, c));
        b.adjVerticesList.addAll(Arrays.asList(a, c));
        c.adjVerticesList.addAll(Arrays.asList(a, b, d));
        d.adjVerticesList.addAll(Arrays.asList(c, e, f));
        e.adjVerticesList.addAll(Arrays.asList(d, f));
        f.adjVerticesList.addAll(Arrays.asList(d, e));
        
        return Arrays.asList(a, b, c, d, e, f);
    }

    static class Vertex {
        String id;
        int depth;
        int low;
        List<Vertex> adjVerticesList;
        Vertex parent;
        int childCount;
        boolean isCutVertex;
        boolean isVisited;

        public Vertex(String id) {
            this.id = id;
            this.adjVerticesList = new LinkedList<Vertex>();
        }
    }

}
