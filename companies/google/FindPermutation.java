package google;

public class FindPermutation {

	public static void main(String[] args) {
		String s = "DI";
		int[] result = findPermutation(s);
		for(int i: result) System.out.print(i + " ");
	}

	private static int[] findPermutation(String s) {
		int n = s.length(), left = 1, right = n + 1;
		int[] result = new int[n + 1];
		
		for(int i = 0; i < n; i++)
			result[i] = s.charAt(i) == 'I' ? left++ : right--;
		
		result[n] = left;
		return result;
	}

}
