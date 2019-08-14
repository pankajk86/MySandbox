package amazon;

import graphs.UnionFind;

public class NumberOfConnectedComponentsInGraph {

	public static void main(String[] args) {
		int n = 5;
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 3, 4 } };
		int result = countComponents(n, edges);
		System.out.println(result);
	}

	private static int countComponents(int n, int[][] edges) {
		UnionFind uf = new UnionFind(n);
        
        for(int i = 0; i < edges.length; i++)
            uf.union(edges[i][0], edges[i][1]);
        
        return uf.getCount();
	}

}
