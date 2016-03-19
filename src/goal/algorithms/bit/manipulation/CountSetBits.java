package goal.algorithms.bit.manipulation;

public class CountSetBits {

	public static void main(String[] args) {

		int n = 109; // 1101101
		int count = 0;
		
		// Brian Kernighan’s Algorithm
		while(n != 0) {
			n = n & (n-1);
			count++;
		}
		
		System.out.println(count);
	}

}
