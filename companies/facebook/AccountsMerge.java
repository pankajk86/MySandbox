package facebook;

import java.util.*;

public class AccountsMerge {

	public static void main(String[] args) {
		List<List<String>> accounts = new ArrayList<>();
		accounts.addAll(Arrays.asList(
					Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
					Arrays.asList("John", "johnnybravo@mail.com"),
					Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
					Arrays.asList("Mary", "mary@mail.com")
				));
		
		List<List<String>> result = mergeAccounts(accounts);
		System.out.println(result);
	}

	private static List<List<String>> mergeAccounts(List<List<String>> accounts) {
		UnionFind uf = new UnionFind(accounts.size());
		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < accounts.size(); i++) {
			List<String> account = accounts.get(i);
			for (int j = 1; j < account.size(); j++) {
				String email = account.get(j);
				if (map.containsKey(email)) {
					uf.union(i, map.get(email));
				} else {
					map.put(email, i);
				}
			}
		}

		Map<Integer, List<String>> groups = new HashMap<>();

		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			int leader = uf.find(entry.getValue());
			List<String> group = groups.getOrDefault(leader, new ArrayList<>());
			group.add(entry.getKey());
			groups.put(leader, group);
		}

		List<List<String>> result = new ArrayList<>();
		for (Map.Entry<Integer, List<String>> entry : groups.entrySet()) {
			List<String> group = entry.getValue();
			Collections.sort(group);
			String name = accounts.get(entry.getKey()).get(0);
			group.add(0, name);
			result.add(group);
		}
		return result;
	}


}

class UnionFind {
	private int[] parent, rank;

	public UnionFind(int n) {
		this.parent = new int[n];
		this.rank = new int[n];

		for (int i = 0; i < n; i++) this.parent[i] = i;
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
		if (rootP == rootQ) return;
		if (rank[rootP] > rank[rootQ]) {
			parent[rootQ] = rootP;
		} else {
			parent[rootP] = rootQ;
			if (rank[rootP] == rank[rootQ]) {
				rank[rootQ]++;
			}
		}
	}
}
