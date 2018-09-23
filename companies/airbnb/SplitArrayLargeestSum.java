package airbnb;

public class SplitArrayLargeestSum {

	public static void main(String[] args) {
		int[] a = {7, 2, 5, 10, 8};
		int m = 2;
		
		int result = splitArray(a, m);
		System.out.println(result);
	}

	private static int splitArray(int[] a, int m) {

		int max = 0;
		long sum = 0L;
		
		for(int i: a) {
			max = Math.max(max, i);
			sum += i;
		}
		
		if(m == 1) return (int) sum;
		
		long l = max, r = sum;
		
		while(l <= r) {
			long mid = (l + r) / 2;
			if(valid(mid, a, m)) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return (int) l;
	}

	private static boolean valid(long mid, int[] a, int m) {

		int count = 1;
		long total = 0L;
		
		for(int i: a) {
			total += i;
			if(total > mid) {
				total = i;
				count++;
				if(count > m)
					return false;
			}
		}
		
		return true;
	}

}
