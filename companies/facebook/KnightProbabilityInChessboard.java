package facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnightProbabilityInChessboard {

	private static int[][] dirs = { { 2, 1 }, { 1, 2 }, { -2, 1 }, { -1, 2 }, { -2, -1 }, { -1, -2 }, { 1, -2 }, { 2, -1 } };
	
	public static void main(String[] args) {
		int n = 8, k = 30, r = 6, c = 4;
		double result = knightProbabilityDP(n, k, r, c);
		System.out.println(result);
	}
	
	
	private static double knightProbabilityDP(int n, int k, int r, int c) {
		double[][] dp = new double[n][n];
		for(double[] row: dp) Arrays.fill(row, 1);
		
		for(int l = 0; l < k; l++) {
			double[][] cache = new double[n][n];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					for(int[] dir: dirs) {
						int x = i + dir[0], y = j + dir[1];
						if(x >= 0 && x < n && y >= 0 && y < n)
							cache[i][j] += dp[x][y];
					}
				}
			}
			dp = cache;
		}
		
		return dp[r][c] / Math.pow(8, k);
	}

	@SuppressWarnings("unused") // not passing all test cases
	private static double knightProbability(int n, int k, int r, int c) {
		if(r < 0 || c < 0) return 0.0d;
		
		List<int[]> positions = new ArrayList<>();
		positions.add(new int[] {r, c});
		
		double result = 1.0d;
		for(int i = 0, j = 0; i < positions.size() && j < k; i++, j++) {
			int[] position = positions.get(i);
			List<int[]> possibleMoves = getMoves(n, position);
			result *= possibleMoves.size() / 8.0;
			positions.addAll(possibleMoves);
		}
		
		return result;
	}

	private static List<int[]> getMoves(int n, int[] pos) {
		List<int[]> result = new ArrayList<>();
		
		for(int[] dir: dirs) {
			int x = pos[0] + dir[0], y = pos[1] + dir[1];
			if(x >= 0 && x < n && y >= 0 && y < n)
				result.add(new int[] {x, y});
		}
		
		return result;
	}

}
