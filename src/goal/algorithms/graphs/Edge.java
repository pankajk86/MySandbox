package goal.algorithms.graphs;

public class Edge<T> {

	private Vertex<T> start;
	private Vertex<T> end;
	
	public Edge(Vertex<T> start, Vertex<T> end) {
		this.start = start;
		this.end = end;
	}

	public Vertex<T> getStart() {
		return start;
	}

	public Vertex<T> getEnd() {
		return end;
	}
	
}
