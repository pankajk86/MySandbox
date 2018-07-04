package arrays;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		int[] a = { 2, 1, 4, 5, 3, 6 };
		int result = getMaxArea(a);
		System.out.println(result);
	}

	private static int getMaxArea(int[] a) {

		int maxArea = 0, left = 0, right = a.length - 1;
		
		while(left < right) {
			int area = Math.min(a[left], a[right]) * (right - left);
			maxArea = Math.max(maxArea, area);
			
			if(a[left] < a[right]) {
				left++;
			} else {
				right--;
			}
		}
		
		return maxArea;
	}

}
