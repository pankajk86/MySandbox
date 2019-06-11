package google;

import java.util.ArrayList;
import java.util.List;

public class BestMeetingPoint {

	public static void main(String[] args) {
		int[][] grid = {
			{ 1, 0, 0, 0, 1 },
			{ 0, 0, 0, 0, 0 },
			{ 0, 0, 1, 0, 0 }
		};
		
		int result = minTotalDistance(grid);
		System.out.println(result);
	}

	private static int minTotalDistance(int[][] grid) {
		List<int[]> people = new ArrayList<>();
		int rows = grid.length, cols = grid[0].length;
		int[][] points = new int[rows * cols][2];
		int k = 0;
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				points[k++] = new int[] {i, j};
				if(grid[i][j] == 1) people.add(new int[] {i, j});
			}
		}
		
		int result = Integer.MAX_VALUE;
		for(int[] point: points) {
			int minDistance = getDistance(point, people);
			result = Math.min(minDistance, result);
		}
		
		return result;
	}

	private static int getDistance(int[] point, List<int[]> people) {
		int distance = 0;
		for(int[] p: people)
			distance += Math.abs(p[0] - point[0]) + Math.abs(p[1] - point[1]);
		return distance;
	}

}
