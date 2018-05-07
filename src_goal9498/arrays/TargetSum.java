package arrays;

public class TargetSum {

	private static int count = 0;
	
	public static void main(String[] args) {
		int[] a = {1, 1, 1, 1, 1};
		int sum = 3;
		
		countWaysForTargetSum(a, sum);
		System.out.println(count);
	}

	private static void countWaysForTargetSum(int[] a, int sum) {
		calculate(a, 0, 0, sum);
	}

	private static void calculate(int[] a, int i, int tempSum, int sum) {

		if(i == a.length) {
			if(tempSum == sum) {
				count++;
			}
		} else {
			calculate(a, i+1, tempSum + a[i], sum);
			calculate(a, i-1, tempSum - a[i], sum);
		}
		
	}

}
