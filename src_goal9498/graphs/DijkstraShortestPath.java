package graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraShortestPath {

	public static void main(String[] args) {
		WeightedGraph g = createGraph1();
		int start  = 0;
		List<int[]> result = shortestPath(g, start);
		print(result);
		
		g = createGraph2();
		result = shortestPath(g, start);
		print(result);
	}

	private static List<int[]> shortestPath(WeightedGraph g, int start) {
		int n = g.size();
		int[] distance = new int[n];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		int[] previous = new int[n];
		Arrays.fill(previous, -1);
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				if(a[1] < b[1]) return -1;
				else if(a[1] > b[1]) return 1;
				return 0;
			}
		});
		
		distance[start] = 0;
		pq.add(new int[] {start, 0});
		
		while(!pq.isEmpty()) {
			int[] curr = pq.poll();
			
			for(int[] neighbor: g.getNeighbors(curr[0])) {
				int node = neighbor[0];
				
				if(node != previous[curr[0]]) {
					int dist = curr[1] + neighbor[1];
					
					if(distance[node] > dist) {
						distance[node] = dist;
						previous[node] = curr[0];
						pq.add(new int[] {node, dist});
					}
				}
			}
		}
		
		return Arrays.asList(distance, previous);
	}
	
	private static void print(List<int[]> result) {
		System.out.println("Distance:");
		for(int i = 0; i < result.get(0).length; i++)
			System.out.print("(" + i + ", " + result.get(0)[i] + ") " );
		
		System.out.println("\nPrevious:");
		for(int i = 0; i < result.get(1).length; i++)
			System.out.print("(" + i + ", " + result.get(1)[i] + ") " );
		
		System.out.println("\n==========");
	}

	/**
	 * @return https://imagebin.ca/v/4dquq93xr7YW
	 */
	private static WeightedGraph createGraph1() {
		WeightedGraph g = new WeightedGraph(6);
		List<int[]> edges = Arrays.asList(
				new int[] {0, 1, 7},
				new int[] {0, 2, 9},
				new int[] {0, 5, 14},
				new int[] {1, 2, 10},
				new int[] {1, 3, 15},
				new int[] {2, 3, 11},
				new int[] {2, 5, 2},
				new int[] {3, 4, 6},
				new int[] {4, 5, 9}
				);
		
		g.addUndirectedEdges(edges);
		return g;
	}
	
	/**
	 * @return https://imagebin.ca/v/4dr1PacoHQVZ
	 */
	private static WeightedGraph createGraph2() {
		WeightedGraph g = new WeightedGraph(7);
		List<int[]> edges = Arrays.asList(
				new int[] {0, 1, 3},
				new int[] {0, 2, 5},
				new int[] {0, 3, 6},
				new int[] {1, 3, 2},
				new int[] {2, 3, 2},
				new int[] {2, 4, 6},
				new int[] {2, 5, 3},
				new int[] {2, 6, 7},
				new int[] {3, 5, 9},
				new int[] {4, 5, 5},
				new int[] {4, 6, 2},
				new int[] {5, 6, 1}
				);
		
		g.addUndirectedEdges(edges);
		return g;
	}

}
