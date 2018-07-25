package google;

public class BombEnemy {

	public static void main(String[] args) {
		char[][] grid = {
				{'0', 'E', '0', '0'},
				{'E', '0', 'W', 'E'},
				{'0', 'E', '0', '0'}
		};
		
		int result = maxKilledEnemies(grid);
		System.out.println(result);
	}

	private static int maxKilledEnemies(char[][] grid) {

		int rows = grid.length, cols = grid[0].length;
		int result = 0;
		int rowKills = 0, colKills[] = new int[cols];
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				
				// rowKills
				if(j == 0 || grid[i][j - 1] == 'W') {
					rowKills = 0;
					
					for(int k = j; k < cols && grid[i][k] != 'W'; k++) {
						if(grid[i][k] == 'E') {
							rowKills++;
						}
					}
				}
				
				// colKills
				if(i == 0 || grid[i-1][j] == 'W') {
					colKills[j] = 0;
					
					for(int k = i; k < rows && grid[k][j] != 'W'; k++) {
						if(grid[k][j] == 'E') {
							colKills[j]++;
						}
					}
				}
				
				if(grid[i][j] == '0') {
					result = Math.max(result, rowKills + colKills[j]);
				}
			}
		}
		
		return result;
	}

}
