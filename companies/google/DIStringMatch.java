package google;

public class DIStringMatch {

	public static void main(String[] args) {
		String s = "IDID";
		int[] result = diStringMatch(s);
		
		for(int i: result) System.out.print(i + " ");
	}

	private static int[] diStringMatch(String s) {
		int n = s.length(), left = 0, right = n;
		int[] result = new int[n + 1];
		
		for(int i = 0; i < n; i++)
			result[i] = s.charAt(i) == 'I' ? left++ : right--;
		
		result[n] = left;
		return result;
	}

}
