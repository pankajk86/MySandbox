package google;

import java.util.Random;

public class RandomPickWithWeight {

	public static void main(String[] args) {
		int[] a = {1, 3};
		
		RandomPick rp = new RandomPick(a);
		System.out.println(rp.pickIndex());
		System.out.println(rp.pickIndex());
		System.out.println(rp.pickIndex());
		System.out.println(rp.pickIndex());
	}

}

class RandomPick {
	
	private Random rand;
	private int[] prefixSum;
	private int total;
	
	RandomPick(int[] w) {
		rand = new Random();
		int n = w.length;
		prefixSum = new int[n];

		for (int i = 0; i < w.length; i++) {
			total += w[i];
			prefixSum[i] = total;
		}
	}
	
	public int pickIndex() {
		int r = rand.nextInt(prefixSum.length);
		int left = 0, right = prefixSum.length - 1;

		while (left < right) {
			int mid = left + (right - left) / 2;
			if (r < prefixSum[mid]) right = mid;
			else left = mid + 1;
		}
		return right;
	}
}
