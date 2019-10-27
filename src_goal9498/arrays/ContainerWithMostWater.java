package arrays;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		int[] a = { 2, 1, 4, 5, 3, 6 };
		int result = getMaxArea(a);
		System.out.println(result);
	}

	private static int getMaxArea(int[] a) {
		int result = 0;
		if(a == null || a.length == 0) return 0;
		
		for(int i = 0, j = a.length - 1; i < j; ) {
			int ai = a[i], aj = a[j];
			int area = Math.min(ai, aj) * (j - i);
			result = Math.max(result, area);
			
			if(ai < aj) {
				while(i < j && a[i] <= ai) i++;
			} else {
				while(i < j && a[j] <= aj) j--;
			}
		}
		
		return result;
	}

}
