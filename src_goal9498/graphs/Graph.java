package graphs;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	private int n;
	private List<Integer> adj[];
	
	@SuppressWarnings("unchecked")
	public Graph(int n) {
		this.n = n;
		this.adj = new ArrayList[n];
		
		for(int i = 0; i < n; i++) {
			this.adj[i] = new ArrayList<>();
		}
	}
	
	public void addEdge(int v, int w) {
		this.adj[v].add(w);
	}
	
	public void addUndirectedEdge(int v, int w) {
		this.adj[v].add(w);
		this.adj[w].add(v);
	}
	
	public int size() {
		return this.n;
	}
	
	public List<Integer> getNeighbors(int v) {
		return this.adj[v];
	}
}

