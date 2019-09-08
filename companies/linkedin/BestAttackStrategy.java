package linkedin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BestAttackStrategy {

	public static void main(String[] args) {
		int[][] a = {
				{1, 1, 1},
				{1, 0, 0},
				{1, 0, 1}
		};
		
		List<Strategy> result = bestAttack(a, 1);
		System.out.println(result);
	}

	private static List<Strategy> bestAttack(int[][] a, int player) {
		List<Strategy> result = new ArrayList<>();
		if(a == null || a.length == 0) return result;
		
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[0].length; j++) {
				if(a[i][j] == player) {
					int[] count = new int[1];
					helper(a, i, j, count, player);
					result.add(new BestAttackStrategy().new Strategy(i, j, count[0]));
				}
			}
		}
		
		Collections.sort(result, new Comparator<Strategy>() {
			@Override
			public int compare(Strategy s1, Strategy s2) {
				return s2.count - s1.count;
			}
		});
		
		return result;
	}

	private static void helper(int[][] a, int i, int j, int[] count, int player) {
		if(i < 0 || i >= a.length || j < 0 || j >= a[0].length || a[i][j] != player || a[i][j] == -1)
			return;
		
		a[i][j] = -1;
		count[0]++;
		
		helper(a, i - 1, j, count, player);
		helper(a, i, j - 1, count, player);
		helper(a, i + 1, j, count, player);
		helper(a, i, j + 1, count, player);
	}

	class Strategy {
		int x, y, count;
		
		Strategy(int x, int y, int count) {
			this.x = x; this.y = y; this.count = count;
		}
		
		@Override
		public String toString() {
			return "(x: " + x + ", y: " + y + ", count: " + count + ")";
		}
	}
}

