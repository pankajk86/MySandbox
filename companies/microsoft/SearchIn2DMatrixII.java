package microsoft;

public class SearchIn2DMatrixII {

	public static void main(String[] args) {
		int[][] a = {
					  {1,   4,  7, 11, 15},
					  {2,   5,  8, 12, 19},
					  {3,   6,  9, 16, 22},
					  {10, 13, 14, 17, 24},
					  {18, 21, 23, 26, 30}
					};
		
		int target = 20;
		boolean result = search(a, target);
		System.out.println(result);
	}

	private static boolean search(int[][] a, int target) {
		if(a == null || a.length == 0 || a[0].length == 0) return false;
		
		int row = 0, col = a[0].length - 1;
		while(row < a.length && col >= 0) {
			if(a[row][col] == target) return true;
			else if(a[row][col] > target)
				col--;
			else row++;
		}
		
		return false;
	}

}
