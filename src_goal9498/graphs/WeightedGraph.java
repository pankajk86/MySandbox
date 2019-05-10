package graphs;

import java.util.ArrayList;
import java.util.List;

public class WeightedGraph implements IGraph {

	private int n;
	private List<int[]> adj[];
	private List<int[]> edges;
	
	@SuppressWarnings("unchecked")
	public WeightedGraph(int n) {
		this.n = n;
		this.adj = new ArrayList[n];
		
		for(int i = 0; i < n; i++) {
			this.adj[i] = new ArrayList<>();
		}
	}
	
	@Override
	public void addUndirectedEdges(List<int[]> edges) {
		this.edges = edges;
		for(int[] edge: edges) {
			this.adj[edge[0]].add(new int[] {edge[1], edge[2]});
			this.adj[edge[1]].add(new int[] {edge[0], edge[2]});
		}
	}
	
	public List<int[]> getEdges() {
		return this.edges;
	}
	
	public List<int[]> getNeighbors(int u) {
		return this.adj[u];
	}
	
	@Override
	public int size() {
		return this.n;
	}

	@Override
	public void print() {
        for(int i = 0; i < this.n; i++) {
            System.out.print(i + ": ");
            for(int[] j: getNeighbors(i)) 
                System.out.print("(" + j[0] + ", " + j[1] + ") ");
            System.out.println();
        }
    }
}
