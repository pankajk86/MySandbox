package microsoft;

public class SpiralMatrixII {

	public static void main(String[] args) {
		int n = 2;
		int[][] result = generateMatrix(n);
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++)
				System.out.print(result[i][j] + " ");
			System.out.println();
		}
	}

	private static int[][] generateMatrix(int n) {
		int[][] result = new int[n][n];
		if(n == 1) {
			result[0][0] = 1; 
			return result;
		}
		
		int x = 0, y = 0, val = 1;
		if(n % 2 != 0)
			result[n / 2][n / 2] = n * n;
		
		while(n > 0) {
			// move right
			for(int i = 0; i < n - 1; i++)
				result[x][y++] = val++;
			
			// move down
			for(int i = 0; i < n - 1; i++)
				result[x++][y] = val++;
			
			// move left
			for(int i = 0; i < n - 1; i++)
				result[x][y--] = val++;
						
			// move up
			for(int i = 0; i < n - 1; i++)
				result[x--][y] = val++;
			
			n -= 2;
			x++; y++;
		}
		
		return result;
	}

}
