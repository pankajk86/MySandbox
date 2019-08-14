package graphs;

public class UnionFind {

	private int count;
	private int[] parent, rank;

	public UnionFind(int n) {
		this.count = n;
		this.parent = new int[n];
		this.rank = new int[n];

		for (int i = 0; i < n; i++)
			parent[i] = i;
	}

	public int find(int p) {
		while (p != parent[p]) {
			parent[p] = parent[parent[p]];
			p = parent[p];
		}
		return p;
	}

	public void union(int p, int q) {
		int rootP = find(p), rootQ = find(q);

		if (rootP == rootQ)
			return;
		if (rank[rootP] > rank[rootQ]) {
			parent[rootQ] = rootP;
		} else {
			parent[rootP] = rootQ;
			if (rank[rootP] == rank[rootQ])
				rank[rootQ]++;
		}
		count--;
	}

	public int getCount() {
		return count;
	}
}
