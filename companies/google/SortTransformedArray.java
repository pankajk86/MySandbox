package google;

public class SortTransformedArray {

	public static void main(String[] args) {
		int[] nums = { -4, -2, 2, 4 };
		int a = 1, b = 3, c = 5;
		
		int[] result = sortTransformedArray(nums, a, b, c);
		for(int i: result) System.out.print(i + " ");
	}

	private static int[] sortTransformedArray(int[] nums, int a, int b, int c) {
		int n = nums.length;
		int[] result = new int[n];
		int left = 0, right = n - 1;
		int i = a >= 0 ? n - 1 : 0;
		
		while(left <= right) {
			int leftVal = getVal(nums[left], a, b, c);
			int rightVal = getVal(nums[right], a, b, c);
			
			if(a >= 0) {
				if(leftVal >= rightVal) {
					result[i--] = leftVal;
					left++;
				} else {
					result[i--] = rightVal;
					right--;
				}
			} else {
				if(leftVal <= rightVal) {
					result[i++] = leftVal;
					left++;
				} else {
					result[i++] = rightVal;
					right--;
				}
			}
		}
		
		return result;
	}

	private static int getVal(int x, int a, int b, int c) {
		return a * x * x + b * x + c;
	}

}
