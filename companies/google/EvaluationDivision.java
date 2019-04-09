package google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EvaluationDivision {

	public static void main(String[] args) {
		String[][] equations = {{"a","b"},{"b","c"}};
		double[] values = {2.0,3.0};
		String[][] queries = {{"a","b"},{"a","a"},{"x","x"}};
		
		double[] result = calcEquation(equations, values, queries);
		for(double d: result) {
			System.out.print(d + ", ");
		}
	}
	
	private static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
		Map<String, Map<String, Double>> graph = new HashMap<>();
		double[] result = new double[queries.length];
		String u, v;
		
		for(int i = 0; i < equations.length; i++) {
			u = equations[i][0]; 
			v = equations[i][1];
			
			graph.putIfAbsent(u, new HashMap<>());
			graph.get(u).put(v, values[i]);
			graph.putIfAbsent(v, new HashMap<>());
			graph.get(v).put(u, 1 / values[i]);
		}
		
		for(int i = 0; i < queries.length; i++) {
			result[i] = dfs(queries[i][0], queries[i][1], new HashSet<>(), graph);;
		}
		
		return result;
	}

	private static double dfs(String start, String end, Set<String> visited, Map<String, Map<String, Double>> graph) {
		if(!graph.containsKey(start)) return -1.0D;
		
		if(graph.get(start).containsKey(end))
			return graph.get(start).get(end);
		
		visited.add(start);
		
		for(Map.Entry<String, Double> entry: graph.get(start).entrySet()) {
			if(!visited.contains(entry.getKey())) {
				double product = dfs(entry.getKey(), end, visited, graph);
				if(product != -1.0D)
					return entry.getValue() * product;
			}
		}
		return -1.0D;
	}
}
