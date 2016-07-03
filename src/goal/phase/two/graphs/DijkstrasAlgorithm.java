package goal.phase.two.graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstrasAlgorithm {

    public static void main(String[] args) {
        List<Vertex> graph = getGraphWithFiveVertices();

        /*
         * Priority queue to store unvisited nodes by their distances.
         */
        PriorityQueue<Vertex> unvisited = new PriorityQueue<Vertex>();

        Vertex start = null;

        for (Vertex vertex : graph) {
            if (vertex.distance == 0) {
                start = vertex;
                break;
            }
        }

        unvisited.add(start);

        while (!unvisited.isEmpty()) {
            Vertex v = unvisited.poll();

            for (Vertex w : v.adjVerticesList) {
                int distance = v.distance + v.weightsMap.get(w);

                if (w.distance == -1) {
                    w.distance = distance;
                    w.parent = v;
                    unvisited.add(w);
                } else if (w.distance > distance) {
                    w.parent = v;
                    unvisited.remove(w);
                    w.distance = distance;
                    unvisited.add(w);
                }
            }
        }

        for (Vertex v : graph) {
            System.out.print("Distance to " + start.id + ": " + v.distance + ", Path: ");
            while (v.parent != null) {
                System.out.print(v.id + "->");
                v = v.parent;
            }
            System.out.println(start.id);
        }

        System.out.println("Dijkstra's Algorithm done!");
    }

    /**
     * a---b
     * |  / \
     * | /   e
     * |/   /
     * c---d
     * 
     * a->b(4), a->c(1), c->b(2), c->d(4), b->e(4),, d->e(4) 
     * 
     * @return
     */
    private static List<Vertex> getGraphWithFiveVertices() {
        
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");
        Vertex d = new Vertex("d");
        Vertex e = new Vertex("e");

        a.weightsMap.put(b, 4);
        a.weightsMap.put(c, 1);
        b.weightsMap.put(e, 4);
        c.weightsMap.put(b, 2);
        c.weightsMap.put(d, 4);
        d.weightsMap.put(e, 4);

        a.distance = 0;

        a.adjVerticesList.addAll(Arrays.asList(b, c));
        b.adjVerticesList.add(e);
        c.adjVerticesList.addAll(Arrays.asList(b, d));
        d.adjVerticesList.add(e);
        
        return Arrays.asList(a, b, c, d, e);

    }

    /**
     * Helper Class
     * 
     * Implemented Comparable, in order to add Vertex in PriorityQueue.
     */
    static class Vertex implements Comparable<Vertex> {
        String id;
        int distance;
        List<Vertex> adjVerticesList;
        Map<Vertex, Integer> weightsMap;
        Vertex parent;

        public Vertex(String id) {
            this.id = id;
            this.distance = -1;
            this.adjVerticesList = new LinkedList<Vertex>();
            this.weightsMap = new HashMap<Vertex, Integer>();
        }

        @Override
        public int compareTo(Vertex o) {

            if (this.distance > o.distance) {
                return 1;
            } else {
                return -1;
            }
        }
    }

}
