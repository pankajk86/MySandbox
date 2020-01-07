package uber;

public class test1 {

	public static void main(String[] args) {
		int n = 1010;
		int result = process(n);
		System.out.println(result);
	}

	private static int process(int n) {
		int prod = 1, sum = 0;
		while(n > 0) {
			int val = n % 10;
			prod *= val; sum += val;
			n /= 10; 
		}
		return prod - sum;
	}

}
