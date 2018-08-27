package uber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class CourseSchedulerII {
	
	static Stack<Integer> stack = new Stack<>();
	static boolean hasCycle = false;

	public static void main(String[] args) {
		int[][] a = {
				{1, 2}, {1, 8},
				{2, 3}, {4, 2},
				{4, 5}, {5, 6},
				{6, 7} //, {7, 4}
		};
		int n = 8;
		
		int[] result = findOrder(n, a);
		
		for(int i: result)
			System.out.print(i + ", ");
	}

	private static int[] findOrder(int n, int[][] a) {
		int[] empty = {};
		Map<Integer, List<Integer>> graph = createGraph(a);
		
		if(graph.isEmpty()) {
			empty = new int[n];
			for(int i = n - 1, j = 0; i >= 0; i--, j++)
				empty[j] = i;
			return empty;
		}
		
		boolean[] visited = new boolean[n + 1];
		Set<Integer> currSet = null;
		Stack<Integer> currStack = null;
		
		for(Map.Entry<Integer, List<Integer>> entry: graph.entrySet()) {
			if(!visited[entry.getKey()]) {
				currSet = new HashSet<>();
				currStack = new Stack<>();
				
				currSet.add(entry.getKey());
				currStack.push(entry.getKey());
				dfs(graph, visited, currSet, currStack);
			}
		}
		
		if(!hasCycle) {
			int size = stack.size();
			empty = new int[size];
			for(int i = size - 1; i >= 0; i--) {
				empty[i] = stack.pop();
			}
		}
		
		return empty;
	}
	
	public static void dfs(Map<Integer, List<Integer>> graph, boolean[] visited, Set<Integer> currSet, Stack<Integer> currStack) {
		
		while(!currStack.isEmpty()) {
			int current = currStack.peek();
			
			if(!visited[current])
				visited[current] = true;
				
			if(graph.containsKey(current)) {
				for(Integer pre: graph.get(current)) {
					if(currSet.contains(pre)) {
						hasCycle = true;
						return;
					}
					if(!visited[pre]) {
						currSet.add(pre);
						currStack.push(pre);
						dfs(graph, visited, currSet, currStack);
					}
				}
				if(!currStack.isEmpty()) {
					if(hasCycle) {
						currSet.remove(currStack.pop());
					} else {
						int done = currStack.pop();
						stack.push(done);
						currSet.remove(done);
					}
				}
			} else {
				if(!currStack.isEmpty()) {
					if(hasCycle) {
						currSet.remove(currStack.pop());
					} else {
						int done = currStack.pop();
						stack.push(done);
						currSet.remove(done);
					}
				}
			}
		}
	}

	private static Map<Integer, List<Integer>> createGraph(int[][] a) {
		
		Map<Integer, List<Integer>> graph = new HashMap<>();
		
		for(int[] pre: a) {
			List<Integer> list = null;
			if(!graph.containsKey(pre[0]))
				list = new ArrayList<>();
			else 
				list = graph.get(pre[0]);
			
			list.add(pre[1]);
			graph.put(pre[0], list);
		}
		
		return graph;
	}

}

