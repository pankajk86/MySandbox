package goal9498.dp;

import java.util.HashMap;
import java.util.Map;

public class UniqueDigits {

	public static void main(String[] args) {

		for (int i = 2; i <= 8; i++) {
			long start = System.currentTimeMillis();
			int count = countNumbersWithUniqueDigits(i);
			long end = System.currentTimeMillis();

			System.out.println("For n = " + i + ", count: " + count + ", time taken: " + (end - start) + " ms");
		}
	}
	
	private static int countNumbersWithUniqueDigits(int n) {
		
		int[] totalCount = new int[n+1];
		totalCount[0] = 1;
		
		for(int i=1; i<=n; i++) {
			int start = (int) Math.pow(10, i-1);
			int end = (int) Math.pow(10, i) - 1;
			
			totalCount[i] = totalCount[i-1] + countNumbersWithUniqueDigits(start, end);
		}
		
		return totalCount[n];
	}

	private static int countNumbersWithUniqueDigits(int start, int end) {

		int count = 0;

		Map<Integer, Integer> map = null;

		for (int i = start; i <= end; i++) {
			map = new HashMap<>();
			boolean flag = true;
			int k = i;

			while (k > 0) {
				int r = k % 10;

				if (!map.containsKey(r)) {
					map.put(r, 1);
				} else {
					flag = false;
					break;
				}
				k /= 10;
			}

			if (flag) {
				count++;
			}
		}

		return count;
	}

}
