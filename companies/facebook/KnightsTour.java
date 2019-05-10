package facebook;

public class KnightsTour {

	private static int[][] dirs = { { 2, 1 }, { 1, 2 }, { -2, 1 }, { -1, 2 }, { -2, -1 }, { -1, -2 }, { 1, -2 }, { 2, -1 } };

	public static void main(String[] args) {
		int[][] a = new int[6][6];
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[0].length; j++)
				a[i][j] = -1;
		}
		
		a[0][0] = 0;
		boolean result = knightsTour(a, 0, 0, 1);
		if(result) {
			for(int i = 0; i < a.length; i++) {
				for(int j = 0; j < a[0].length; j++)
					System.out.print(a[i][j] + " ");
				System.out.println();
			}
		}
	}

	private static boolean knightsTour(int[][] a, int i, int j, int move) {
		int n = a.length;
		if(move == n * n) return true;
		
		for(int[] dir: dirs) {
			int x = i + dir[0], y = j + dir[1];
			if(x >= 0 && x < n && y >= 0 && y < n && a[x][y] == -1) {
				a[x][y] = move;
				if(knightsTour(a, x, y, move + 1)) return true;
				else a[x][y] = -1;
			}
		}
		return false;
	}

}
