package goal.phase.two.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathUnweightedGraph {

    public static void main(String[] args) {

        List<VertexPath> list = getGraphWithSevenVertices();
        Queue<VertexPath> q = new LinkedList<VertexPath>();

        VertexPath start = null;

        for (VertexPath v : list) {
            if (v.distance == 0) {
                start = v;
            }
        }

        q.add(start);

        while (!q.isEmpty()) {
            VertexPath v = q.poll();

            for (VertexPath adj : v.adjVertices) {
                if (adj.distance == -1) {
                    adj.distance = v.distance + 1;
                    adj.parent = v;
                    q.add(adj);
                }
            }
        }

        for (VertexPath v : list) {
            System.out.print("Distance to " + start.id + ": " + v.distance + ", Path: ");
            while (v.parent != null) {
                System.out.print(v.id + "->");
                v = v.parent;
            }
            System.out.println(start.id);
        }

        System.out.println("Shortest distance found!");
    }

    /**
     *  a---b 
     * / \ / \ 
     * c  d  e 
     * \ / \ / 
     *  f---g
     * 
     * Edges: c->a, c->f, a->b, a->d, b->d, b->e, d->f, d->g, e->g, g->f
     * 
     * @return Starting vertex of the graph.
     */
    private static List<VertexPath> getGraphWithSevenVertices() {

        VertexPath a = new VertexPath("a");
        VertexPath b = new VertexPath("b");
        VertexPath c = new VertexPath("c");
        VertexPath d = new VertexPath("d");
        VertexPath e = new VertexPath("e");
        VertexPath f = new VertexPath("f");
        VertexPath g = new VertexPath("g");

        c.distance = 0;

        a.adjVertices.addAll(Arrays.asList(b, d));
        b.adjVertices.addAll(Arrays.asList(d, e));
        c.adjVertices.addAll(Arrays.asList(a, f));
        d.adjVertices.addAll(Arrays.asList(g, f));
        e.adjVertices.add(g);
        g.adjVertices.add(f);


        return Arrays.asList(a, b, c, d, e, f, g);
    }
}

class VertexPath {
    String id;
    int distance;
    List<VertexPath> adjVertices;
    VertexPath parent;

    public VertexPath(String id) {
        this.id = id;
        this.distance = -1;
        this.adjVertices = new LinkedList<VertexPath>();
    }
}
