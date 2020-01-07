package microsoft;

public class StringCompression {

	public static void main(String[] args) {
		char[] a = { 'a', 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'c', 'c', 'c' };
		int result = compress(a);
		System.out.println(result);
	}

	private static int compress(char[] a) {
		int result = 0, i = 0, j = 0;
		for(; j < a.length; j++) {
			if(a[j] != a[i]) {
				result += 1 + (j - i > 1 ?String.valueOf(j - i).length() : 0);
				i = j;
			}
		}
		
		result += 1 + (j - i > 1 ?String.valueOf(j - i).length() : 0);
		return result;
	}

}
