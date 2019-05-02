package google;

import java.util.LinkedList;
import java.util.Queue;

public class CheckBipartiteGraph {

	public static void main(String[] args) {
		
		int[][] graph = {
				{1, 3},
				{0, 2},
				{1, 3},
				{0, 2},
			};
		
		boolean result = isBipartite(graph);
		System.out.println(result);
	}

	private static boolean isBipartite(int[][] graph) {
		//0 -> not meet, 1 -> white, 2 -> black
		int size = graph.length;
		int[] visited = new int[size];
		
		for(int i = 0; i < size; i++) {
			if(graph[i].length > 0 && visited[i] == 0) {
				Queue<Integer> q = new LinkedList<>();
				q.add(i);
				
				while(!q.isEmpty()) {
					int curr = q.poll();
					for(int n: graph[curr]) {
						if(visited[n] == 0) {
							visited[n] = visited[curr] == 1 ? 2 : 1;
							q.add(n);
						} else {
							if(visited[n] == visited[curr]) return false;
						}
					}
				}
			}
		}
		return true;
	}

}
