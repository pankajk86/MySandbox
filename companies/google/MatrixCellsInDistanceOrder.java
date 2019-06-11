package google;

import java.util.Arrays;
import java.util.Comparator;

public class MatrixCellsInDistanceOrder {

	public static void main(String[] args) {
		int r = 2, c = 3, x = 1, y = 2;
		int[][] result = allCellsInDistanceOrder(r, c, x, y);
		
		for(int[] a: result) System.out.println(a[0] + " " + a[1]);
	}

	private static int[][] allCellsInDistanceOrder(int r, int c, int x, int y) {
		int[][] result = new int[r * c][2];
		int k = 0;
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++)
				result[k++] = new int[] {i, j};
		}
		
		Arrays.sort(result, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				int d1 = Math.abs(a[0] - x) + Math.abs(a[1] - y);
				int d2 = Math.abs(b[0] - x) + Math.abs(b[1] - y);
				return d1 - d2;
			}
		});
		return result;
	}

}
