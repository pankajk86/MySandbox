package goal.phase.two.graphs;

import java.util.LinkedList;
import java.util.List;

public class Graph {

    List<Vertex> vertices;

    public Graph() {
        this.vertices = new LinkedList<Vertex>();
    }

    public List<Vertex> getVertices() {
        return this.vertices;
    }
}

class Vertex {
    String id;
    int distance;
    List<Vertex> adjVertices;

    public Vertex(String id) {
        this.id = id;
        this.distance = -1;
        this.adjVertices = new LinkedList<Vertex>();
    }
}
