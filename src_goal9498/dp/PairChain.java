package dp;

import java.util.Arrays;

public class PairChain {

	public static void main(String[] args) {
		int[][] a = new int[][] { { 1, 2 }, { 9, 10 }, { 2, 3 }, { 3, 7 }, { 5, 8 }, { 3, 4 } };

		int maxLength = getMaxChainLength(a);
		System.out.println(maxLength);
	}

	private static int getMaxChainLength(int[][] pairs) {
		int maxLength = 1;

		Pair[] list = new Pair[pairs.length];

		for (int i = 0; i < pairs.length; i++) {
			Pair p = new Pair(pairs[i][0], pairs[i][1]);
			list[i] = p;
		}

		Arrays.sort(list);

		int n = list.length;
		int[] m = new int[n];

		for (int i = 0; i < n; i++) {
			m[i] = 1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (list[i].start > list[j].end && m[i] < m[j] + 1) {
					m[i] = m[j] + 1;
				}
			}
		}

		for (int i : m) {
			if (i > maxLength) {
				maxLength = i;
			}
		}

		return maxLength;
	}

}

class Pair implements Comparable<Pair> {
	int start, end;

	Pair(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Pair other) {
		if (this.start != other.start) {
			return this.start - other.start;
		} else {
			return this.end - other.end;
		}
	}
}
