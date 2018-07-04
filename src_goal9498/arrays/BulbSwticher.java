package arrays;

public class BulbSwticher {

	public static void main(String[] args) {
		int n = 6;
		int result = countBulbsOn(n);
		System.out.println(result);
	}

	private static int countBulbsOn(int n) {

		int result = 0;
		int[] a = new int[n + 1];
		
		for(int i = 1; i<a.length; i++) {
			int count = getFactorsCount(i);
			
			if(count % 2 == 1) {
				a[i] = 1;
				result++;
			}
		}

		return result;
	}

	private static int getFactorsCount(int n) {

		int count = 0;
		
		for(int i = 1; i<=n; i++) {
			if(n%i == 0) {
				count++;
			}
		}
		
		return count;
	}

}
