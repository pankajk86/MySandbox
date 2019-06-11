package amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AllPathsFromSourceToTarget {

	public static void main(String[] args) {
		int[][] graph = {
				{1, 2},
				{3},
				{3, 4},
				{5},
				{},
				{}
			};
		
		List<List<Integer>> result = allPaths(graph);
		System.out.println(result);
	}

	private static List<List<Integer>> allPaths(int[][] graph) {
		Map<Integer, List<List<Integer>>> map = new HashMap<>();
		return dfs(graph, 0, map);
	}

	private static List<List<Integer>> dfs(int[][] graph, int node, Map<Integer, List<List<Integer>>> map) {
		if(map.containsKey(node)) return map.get(node);
		
		List<List<Integer>> result = new ArrayList<>();
		if(node == graph.length - 1) {
			List<Integer> path = new LinkedList<>();
			path.add(node);
			result.add(path);
		} else {
			for(int nextNode: graph[node]) {
				List<List<Integer>> subPaths = dfs(graph, nextNode, map);
				for(List<Integer> subPath: subPaths) {
					LinkedList<Integer> newPath = new LinkedList<>(subPath);
					newPath.addFirst(node);
					result.add(newPath);
				}
			}
		}
		
		map.put(node, result);
		return result;
	}

}
