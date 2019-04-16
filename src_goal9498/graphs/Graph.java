package graphs;

import java.util.ArrayList;
import java.util.List;

public class Graph implements IGraph {
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
	
	@Override
	public void addUndirectedEdges(List<int[]> edges) {
		for(int[] edge: edges) {
            this.adj[edge[0]].add(edge[1]);
            this.adj[edge[1]].add(edge[0]);
        }
	}
	
	@Override
	public int size() {
		return this.n;
	}
	
	public List<Integer> getNeighbors(int u) {
		return this.adj[u];
	}

	@Override
	public void print() {
        for(int i = 0; i < this.n; i++) {
            System.out.print(i + ": ");
            for(int j: getNeighbors(i))
                System.out.print(j + " ");
            System.out.println();
        }
    }
}

