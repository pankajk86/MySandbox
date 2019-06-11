package google;

public class RedundantConnection {

	public static void main(String[] args) {
		int[][] edges = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 4 }, { 1, 5 } };
		int[] result = redundantEdge(edges);
		
		System.out.println("(" + result[0] + ", " + result[1] + ")");
	}

	private static int[] redundantEdge(int[][] edges) {
		UF uf = new UF(edges.length);
        
        for(int[] edge: edges) {
            if(!uf.union(edge[0] - 1, edge[1] - 1)) return edge;
        }
        return null;
	}

}


class UF {
    private int[] parent;
    private int[] rank;
    
    UF(int n) {
        this.parent = new int[n];
        this.rank = new int[n];
    }
    
    public int find(int x) {
        if(parent[x] == 0) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
    
    public boolean union(int x, int y) {
        int p1 = find(x), p2 = find(y);
        if(p1 == p2) return false;
        
        if(rank[p1] < rank[p2]) parent[p1] = p2;
        else if(rank[p1] > rank[p2]) parent[p2] = p1;
        else {
            parent[p1] = p2;
            rank[p2]++;
        }
        return true;
    }
}
