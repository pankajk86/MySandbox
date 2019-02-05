package uber;

public class WallsAndGates {

	private static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	public static void main(String[] args) {
		int inf = Integer.MAX_VALUE;
		int[][] a = {
				{ inf, -1, 0, inf },
				{ inf, inf, inf, -1 },
				{ inf, -1, inf, -1 },
				{ 0, -1, inf, inf }
		};
		
		populateArrays(a);
		
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[0].length; j++)
				System.out.print(a[i][j] + " ");
			System.out.println();
		}
	}

	private static void populateArrays(int[][] a) {
		int rows = a.length;
		if(rows == 0) return;
		int cols = a[0].length;
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(a[i][j] == 0)
					dfs(a, i, j, rows, cols, 0);
			}
		}
	}

	private static void dfs(int[][] a, int i, int j, int rows, int cols, int step) {
		if(i < 0 || i >= rows || j < 0 || j >= cols) return;
		if(a[i][j] < 0 || a[i][j] < step) return;

		a[i][j] = step;
		
		for(int[] dir: dirs) {
			int x = i + dir[0], y = j + dir[1];
			dfs(a, x, y, rows, cols, a[i][j] + 1);
		}
	}

}
