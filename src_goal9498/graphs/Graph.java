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
	
	public void addEdges(List<int[]> edges) {
		for(int[] edge: edges) {
            this.adj[edge[0]].add(edge[1]);
        }
	}
	
	public void addUndirectedEdges(List<int[]> edges) {
		for(int[] edge: edges) {
            this.adj[edge[0]].add(edge[1]);
            this.adj[edge[1]].add(edge[0]);
        }
	}
	
	public int size() {
		return this.n;
	}
	
	public List<Integer> getNeighbors(int v) {
		return this.adj[v];
	}
}

