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
	private int[] sum;
	
	RandomPick(int[] w) {
		this.rand = new Random();
		this.sum = w;
		
		for(int i = 1; i < sum.length; i++)
			sum[i] += sum[i - 1];
	}
	
	public int pickIndex() {
		int n = sum.length;
		int index = rand.nextInt(sum[n - 1]) + 1;
		int left = 0, right = n - 1;
		
		while(left < right) {
			int mid = left + (right - left) / 2;
			if(sum[mid] == index) return mid;
			else if(sum[mid] < index) left = mid + 1;
			else right = mid;
		}
		return left;
	}
}
