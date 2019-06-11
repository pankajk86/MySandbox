package google;

public class GrumpyBookstoreOwner {

	public static void main(String[] args) {
		int[] customers = { 1, 0, 1, 2, 1, 1, 7, 5 };
		int[] grumpy = { 0, 1, 0, 1, 0, 1, 0, 1 };
		int x = 3;
		
		int result = maxSatisfied(customers, grumpy, x);
		System.out.println(result);
	}

	private static int maxSatisfied(int[] customers, int[] grumpy, int x) {
		int sum = 0;
		for(int i = 0; i < x; i++) sum += customers[i];
		for(int i = x; i < customers.length; i++) {
			if(grumpy[i] == 0) sum += customers[i];
		}
		int result = sum;
		
		for(int low = 0, high = x - 1; high < customers.length;) {
			if(grumpy[low] == 1)
				sum -= customers[low];
			low++; high++;
			
			if(high < customers.length && grumpy[high] == 1)
				sum += customers[high];
			result = Math.max(result, sum);
		}
		return result;
	}

}
