package google;

public class MaxAreaOfIsland {

	public static void main(String[] args) {
		int[][] a = {
			{ 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
			{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
			{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 }
		};
		
		int result = maxArea(a);
		System.out.println(result);
	}

	private static int maxArea(int[][] a) {
		if(a == null || a.length == 0) return 0;
		int rows = a.length, cols = a[0].length;
		
		boolean[][] visited = new boolean[rows][cols];
		int result = 0;
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				result = Math.max(result, dfs(a, visited, i, j));
			}
		}
		
		return result;
	}

	private static int dfs(int[][] a, boolean[][] visited, int i, int j) {
		if(i < 0 || i >= a.length || j < 0 || j >= a[0].length || visited[i][j] || a[i][j] == 0)
			return 0;
		
		visited[i][j] = true;
		
		return 1 + dfs(a, visited, i + 1, j)
		 		 + dfs(a, visited, i - 1, j)
		 		 + dfs(a, visited, i, j + 1)
		 		 + dfs(a, visited, i, j - 1);
	}

}
