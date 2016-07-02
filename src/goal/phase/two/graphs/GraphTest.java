package goal.phase.two.graphs;

import java.util.Arrays;

public class GraphTest {

    public static void main(String[] args) {

        Graph g = getGraphWithSevenVertices();
        System.out.println("Graph created with # of nodes: " + g.vertices.size());
    }

    /**
     *   a---b
     *  / \ / \
     * c   d   e
     *  \ / \ /
     *   f---g
     *   
     * Edges: c->a, c->f, a->b, a->d, b->d, b->e, d->f, d->g, e->g, g->f
     * 
     * @return Starting vertex of the graph.
     */
    private static Graph getGraphWithSevenVertices() {
        Graph graph = new Graph();

        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");
        Vertex d = new Vertex("d");
        Vertex e = new Vertex("e");
        Vertex f = new Vertex("f");
        Vertex g = new Vertex("g");

        a.adjVertices.addAll(Arrays.asList(b, d));
        b.adjVertices.addAll(Arrays.asList(d, e));
        c.adjVertices.addAll(Arrays.asList(a, f));
        d.adjVertices.addAll(Arrays.asList(g, f));
        e.adjVertices.add(g);
        g.adjVertices.add(f);

        graph.vertices.addAll(Arrays.asList(a, b, c, d, e, f, g));

        return graph;
    }
}