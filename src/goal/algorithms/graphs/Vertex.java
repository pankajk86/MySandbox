package goal.algorithms.graphs;

import java.util.LinkedList;
import java.util.List;

public class Vertex<T> {

    private int id;
    private List<Vertex<T>> adjVertices;
    private boolean explored = false;

    public Vertex(int id) {
        adjVertices = new LinkedList<Vertex<T>>();
        this.id = id;
    }

    public List<Vertex<T>> getAdjVertices() {
        return adjVertices;
    }

    public boolean isExplored() {
        return explored;
    }

    public int getId() {
        return this.id;
    }

    public void setExplored(boolean explored) {
        this.explored = explored;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

}
