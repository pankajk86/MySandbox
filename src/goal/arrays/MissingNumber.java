package goal.arrays;

public class MissingNumber {

	public static void main(String[] args) {

		int[] a = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
		int result = missingNumber(a);
		System.out.println(result);
	}

	private static int missingNumber(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
        int n = nums.length, sum = 0;

        for (int num : nums) sum += num;
        int expectedSum = n * (n + 1) / 2;
        return expectedSum - sum;
	}

}
