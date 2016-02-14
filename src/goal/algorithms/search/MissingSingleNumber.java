package goal.algorithms.search;

public class MissingSingleNumber {

	public static void main(String[] args) {
		int arr[] = {1, 2, 2, 1, 3, 4, 3};
		int singleNumber = missingSingleNumber(arr);
		System.out.println("Number with single occurance: " + singleNumber);
	}

	private static int missingSingleNumber(int[] arr) {
		int missingNum = arr[0];
		for(int i=1; i< arr.length; i++) {
			missingNum ^= arr[i];  // bitwise XOR
		}
		return missingNum;
	}

}
