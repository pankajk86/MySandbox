package google;

public class ScoreAfterFlippingMatrix {

	public static void main(String[] args) {
		int[][] a = {
				{ 0, 0, 1, 1 },
				{ 1, 0, 1, 0 },
				{ 1, 1, 0, 0 }
			};
		int result = maxScore(a);
		System.out.println(result);
	}

	private static int maxScore(int[][] a) {
		int rows = a.length, cols = a[0].length;
		int result = (1 << (cols - 1)) * rows;
		
		for(int j = 1; j < cols; j++) {
			int curr = 0;
			for(int i = 0; i < rows; i++)
				curr += a[i][j] == a[i][0] ? 1 : 0;
			result += Math.max(curr, rows - curr) * (1 << (cols - j - 1));
		}
		
		return result;
	}

}
