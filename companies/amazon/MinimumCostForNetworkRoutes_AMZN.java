package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumCostForNetworkRoutes_AMZN {

	public static void main(String[] args) {
		int numTotalEdgeNodes = 6;
        int numTotalAvailableNetworkRoutes = 4;
        List<List<Integer>> networkRoutesAvailable = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<Integer> l3 = new ArrayList<>();
        List<Integer> l4 = new ArrayList<>();
        l1.addAll(Arrays.asList(1, 2));
        l2.addAll(Arrays.asList(2, 3));
        l3.addAll(Arrays.asList(4, 5));
        l4.addAll(Arrays.asList(3, 5));
        networkRoutesAvailable.addAll(Arrays.asList(l1, l2, l3, l4));
        
        int numNewNetworkRoutesConstruct = 2;
        List<List<Integer>> costNewNetworkRoutesConstruct = new ArrayList<>();
        List<Integer> c1 = new ArrayList<>();
        List<Integer> c2 = new ArrayList<>();
//        List<Integer> c3 = new ArrayList<>();
//        List<Integer> c4 = new ArrayList<>();
        c1.addAll(Arrays.asList(1, 6, 410));
        c2.addAll(Arrays.asList(2, 4, 800));
//        c3.addAll(Arrays.asList(1, 6, 2));
//        c4.addAll(Arrays.asList(5, 6, 5));
        costNewNetworkRoutesConstruct.addAll(Arrays.asList(c1, c2));
        
        int result = minimumCostIncurred(numTotalEdgeNodes, numTotalAvailableNetworkRoutes, 
        		networkRoutesAvailable, numNewNetworkRoutesConstruct, costNewNetworkRoutesConstruct);
        System.out.println(result);
	}

	private static int minimumCostIncurred(int numTotalEdgeNodes, int numTotalAvailableNetworkRoutes,
			List<List<Integer>> networkRoutesAvailable, int numNewNetworkRoutesConstruct,
			List<List<Integer>> costNewNetworkRoutesConstruct) {
		
		int minSingleCost = checkForSingleUnvisitedNodes(numTotalEdgeNodes, networkRoutesAvailable, costNewNetworkRoutesConstruct);
		if(minSingleCost != Integer.MAX_VALUE)
			return minSingleCost;
		
		int result = 0;
        boolean[] visited = new boolean[numTotalEdgeNodes];
        int[] keys = new int[numTotalEdgeNodes];
        int[] parent = new int[numTotalEdgeNodes];
        
        int[][] adjMatrix = getAdjacencyMatrix(networkRoutesAvailable, costNewNetworkRoutesConstruct, numTotalEdgeNodes);
        Arrays.fill(keys, Integer.MAX_VALUE);
        
        keys[0] = 0;
        parent[0] = -1;
        
        for(int i = 0; i<numTotalEdgeNodes - 1; i++){
            int u = findMin(visited, keys);
            visited[u] = true;
            for(int v = 0; v < numTotalEdgeNodes; v++){
                if(visited[v] == false && adjMatrix[u][v] != Integer.MAX_VALUE && adjMatrix[u][v]<keys[v]){
                    parent[v] = u;
                    keys[v] = adjMatrix[u][v];
                }
            }
        }
        
        for(int i = 1; i< numTotalEdgeNodes; i++){
            result += adjMatrix[parent[i]][i];
        }
        return result;
	}

	private static int checkForSingleUnvisitedNodes(int numTotalEdgeNodes,
			List<List<Integer>> networkRoutesAvailable, List<List<Integer>> costNewNetworkRoutesConstruct) {

		Set<Integer> set = new HashSet<>();
		for(List<Integer> list: networkRoutesAvailable) {
			set.addAll(list);
		}
		
		int missingNode = -1;
		int minCost = Integer.MAX_VALUE;
		if(set.size() == numTotalEdgeNodes - 1) {
			for(int i = 1; i <= numTotalEdgeNodes; i++) {
				if(!set.contains(i)) {
					missingNode = i;
					break;
				}
			}
			for(List<Integer> list: costNewNetworkRoutesConstruct) {
				if(list.get(0) == missingNode || list.get(1) == missingNode) {
					minCost = Math.min(minCost, list.get(2));
				}
			}
		}
		return minCost;
	}

	private static int[][] getAdjacencyMatrix(List<List<Integer>> networkRoutesAvailable,
			List<List<Integer>> costNewNetworkRoutesConstruct, int numTotalEdgeNodes) {
		
		int[][] adjMatrix = new int[numTotalEdgeNodes][numTotalEdgeNodes];
        for(int i = 0; i<numTotalEdgeNodes; i++){
            for(int j = 0; j<numTotalEdgeNodes; j++){
                adjMatrix[i][j] = Integer.MAX_VALUE;
            }
        }
        
        int count = 0; 
        for(int i = 0; i<networkRoutesAvailable.size(); i++){
            int start = networkRoutesAvailable.get(i).get(count) - 1;
            int end = networkRoutesAvailable.get(i).get(count + 1) -1;
            adjMatrix[start][end] = 0;
        }
        
        for(int i = 0; i<costNewNetworkRoutesConstruct.size(); i++){
            int start = costNewNetworkRoutesConstruct.get(i).get(count) - 1;
            int end = costNewNetworkRoutesConstruct.get(i).get(count + 1) -1;
            int cost = costNewNetworkRoutesConstruct.get(i).get(count + 2);
            adjMatrix[start][end] = cost;
        }
        return adjMatrix;
	}

	private static int findMin(boolean[] visited, int[] keys) {
		int min = Integer.MAX_VALUE;
        int index = -1;
        for(int i = 0; i<keys.length; i++){
            if(!visited[i] && keys[i] < min){
                min = keys[i];
                index = i;
            }
        }
        return index;
   }

}
