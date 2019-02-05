package goal.arrays;

public class MissingNumber {

	public static void main(String[] args) {

		int nums[] = { 1, 3, 5, 9, 11 };
		int sum = 29;
		int n = 5;
		int num = (int) (0.5 * (nums[0] + nums[n - 1]) * (n + 1) - sum);
		System.out.println(num);

		int[] a = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
		int result = missingNumber(a);
		System.out.println(result);
	}

	private static int missingNumber(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
        int n = nums.length, sum = 0, expectedSum = 0;
        
        for(int i = 0; i < n; i++) sum += nums[i];
        expectedSum = n * (n + 1) / 2;
        return expectedSum - sum;
	}

}
