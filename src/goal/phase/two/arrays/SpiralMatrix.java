package goal.phase.two.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };

		List<Integer> result = getSpiralTraversal(a);

		for (int i : result) {
			System.out.print(i + " ");
		}
	}

	private static List<Integer> getSpiralTraversal(int[][] a) {

		List<Integer> result = new ArrayList<>();

		int m = a.length, n = a[0].length;
		int x = 0, y = 0;

		while (m > 0 && n > 0) {

			// only one row is left
			if (m == 1) {
				for (int i = 0; i < n; i++) {
					result.add(a[x][y++]);
				}
				break;
			}

			// only one column is left
			else if (n == 1) {
				for (int i = 0; i < m; i++) {
					result.add(a[x++][y]);
				}
				break;
			}

			// move top left to right
			for (int i = 0; i < n - 1; i++) {
				result.add(a[x][y++]);
			}

			// move right top to bottom
			for (int i = 0; i < m - 1; i++) {
				result.add(a[x++][y]);
			}

			// move bottom right to left
			for (int i = 0; i < n - 1; i++) {
				result.add(a[x][y--]);
			}

			// move left bottom to top
			for (int i = 0; i < m - 1; i++) {
				result.add(a[x--][y]);
			}

			x++;
			y++;
			m = m - 2;
			n = n - 2;
		}

		return result;
	}

}
