package graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 * 
 * @author pankajk
 *
 */
public class WeightedGraph {

	private int n;
	private List<Integer> adj[];
	
	@SuppressWarnings("unchecked")
	public WeightedGraph(int n) {
		this.n = n;
		this.adj = new ArrayList[n];
		
		for(int i = 0; i < n; i++) {
			this.adj[i] = new ArrayList<>();
		}
	}
	
	public void addUndirectedEdge(int u, int v, int w) {
		Edge e = new Edge(u, v, w);
		
	}
}

class Edge {
	int start, end, weight;
	
	Edge(int start, int end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
}
