package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumDistanceInMatrix_AMZN {

	public static void main(String[] args) {
		List<List<Integer>> area = createArea();
		int result = minDistance(3, 3, area);
		System.out.println(result);
	}

	private static int minDistance(int numRows, int numCols, List<List<Integer>> area) {

		Item source = new Item(0, 0, 0);
		boolean[][] visited = new boolean[numRows][numCols];
		
		for(int i = 0; i < numRows; i++) {
			for(int j = 0; j < numCols; j++) {
				if(area.get(i).get(j) == 0)
					visited[i][j] = true;
				else visited[i][j] = false;
			}
		}
		
		Queue<Item> q = new LinkedList<>();
		q.add(source);
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			Item item = q.poll();
			
			// destination found
			if(area.get(item.row).get(item.col) == 9)
				return item.dist;
			
			// moving up
			if(item.row - 1 >= 0 && !visited[item.row - 1][item.col]) {
				q.add(new Item(item.row - 1, item.col, item.dist + 1));
				visited[item.row - 1][item.col] = true;
			}
			
			// moving down
			if(item.row + 1 < numRows && !visited[item.row + 1][item.col]) {
				q.add(new Item(item.row + 1, item.col, item.dist + 1));
				visited[item.row + 1][item.col] = true;
			}
			
			// moving left
			if(item.col - 1 >= 0 && !visited[item.row][item.col - 1]) {
				q.add(new Item(item.row, item.col - 1, item.dist + 1));
				visited[item.row][item.col - 1] = true;
			}
			
			// moving right
			if(item.col + 1 < numCols && !visited[item.row][item.col + 1]) {
				q.add(new Item(item.row, item.col + 1, item.dist + 1));
				visited[item.row][item.col + 1] = true;
			}
		}
		
		return -1;
	}

	private static List<List<Integer>> createArea() {
		List<List<Integer>> result = new ArrayList<>();
		
		result.add(Arrays.asList(1, 0, 0));
		result.add(Arrays.asList(1, 0, 0));
		result.add(Arrays.asList(1, 9, 1));
		
		return result;
	}

}


class Item {
	int row; 
    int col; 
    int dist; 
    
    Item(int row, int col, int dist) {
    	this.row = row;
    	this.col = col;
    	this.dist = dist;
    } 
}