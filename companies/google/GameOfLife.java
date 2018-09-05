package google;

public class GameOfLife {

	public static void main(String[] args) {
		int[][] a = {
				{0, 1, 0},
				{0, 0, 1},
				{1, 1, 1},
				{0, 0, 0}
		};
		
		gameOfLife(a);
		
		for(int[] row: a) {
			for(int elem: row)
				System.out.print(elem + " ");
			System.out.println();
		}
	}

	private static void gameOfLife(int[][] a) {
		int[][] cache = new int[a.length + 2][a[0].length + 2];
		
		for(int i = 0; i < cache.length; i++) {
			for(int j = 0; j < cache[0].length; j++) {
				if(i == 0 || j == 0 || i == cache.length - 1 || j == cache[0].length - 1)
					cache[i][j] = -1;
				else 
					cache[i][j] = a[i - 1][j - 1];
			}
		}
		
		for(int i = 1; i < cache.length - 1; i++) {
			for(int j = 1; j < cache[0].length - 1; j++) {
				int live = getLiveNeighbors(cache, i, j);
				
				if(cache[i][j] == 0 && live == 3)
					a[i - 1][j - 1] = 1;
				else {
					if(cache[i][j] == 1 && (live < 2 || live > 3)) {
						a[i - 1][j - 1] = 0;
					}
				}
			}
		}
	}

	private static int getLiveNeighbors(int[][] cache, int i, int j) {
		int count = 0;
		
		count = cache[i - 1][j - 1] == 1 ? count + 1 : count;
		count = cache[i - 1][j] == 1 ? count + 1 : count;
		count = cache[i - 1][j + 1] == 1 ? count + 1 : count;
		
		count = cache[i][j - 1] == 1 ? count + 1 : count;
		count = cache[i][j + 1] == 1 ? count + 1 : count;
		
		count = cache[i + 1][j - 1] == 1 ? count + 1 : count;
		count = cache[i + 1][j] == 1 ? count + 1 : count;
		count = cache[i + 1][j + 1] == 1 ? count + 1 : count;
		
		return count;
	}

}
