package uber;

public class SurroundedRegions {

	private static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	private static char temp = '#';
	
	public static void main(String[] args) {
		char[][] a = {
				{ 'X', 'X', 'X', 'X' },
				{ 'X', 'O', 'O', 'X' },
				{ 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' }
		};
		
		solveSurroundedRegions(a);
		
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[0].length; j++)
				System.out.print(a[i][j] + " ");
			System.out.println();
		}
	}

	private static void solveSurroundedRegions(char[][] a) {
		int rows = a.length;
		if(rows == 0) return;
		int cols = a[0].length;
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if((i == 0 || i == rows - 1 || j == 0 || j == cols - 1) && a[i][j] == 'O') {
					a[i][j] = temp;
					dfs(a, i, j, rows, cols);
				}
			}
		}
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(a[i][j] == temp) a[i][j] = 'O';
				else if(a[i][j] == 'O') a[i][j] = 'X';
			}
		}
	}

	private static void dfs(char[][] a, int i, int j, int rows, int cols) {
		for(int[] dir: dirs) {
			int x = i + dir[0], y = j + dir[1];
			if(x >= 0 && x < rows && y >= 0 && y < cols && a[x][y] == 'O') {
				a[x][y] = temp;
				dfs(a, x, y, rows, cols);
			}
		}
	}

}
