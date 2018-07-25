package arrays;

public class TransposeMatrix {

	public static void main(String[] args) {
		int[][] a = {
				{1, 2, 3, 10 },
				{4, 5, 6, 11 },
				{7, 8, 9, 12 }
		};
		
		int[][] result = transpose(a);
		System.out.println(result);
	}

	private static int[][] transpose(int[][] a) {

		int rows = a.length, cols = a[0].length;
		int[][] result = new int[cols][rows];
		int k = 0, l = 0;
		
		for(int j = 0; j < cols; j++) {
			for(int i = 0; i < rows; i++) {
				result[k][l++] = a[i][j];
			}
			k++; l = 0;
		}
		return result;
	}

}
