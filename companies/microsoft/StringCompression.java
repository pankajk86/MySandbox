package microsoft;

public class StringCompression {

	public static void main(String[] args) {
		char[] a = { 'a', 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'c', 'c', 'c' };
		int result = compress(a);
		System.out.println(result);
	}

	private static int compress(char[] carr) {
		int left = 0, right = 0, index = 0;

		while (right < carr.length) {
			while (right < carr.length && carr[right] == carr[left]) right++;
			carr[index++] = carr[left];
			int count = right - left;
			if (count > 1) {
				for (char c : String.valueOf(count).toCharArray())
					carr[index++] = c;
			}
			left = right;
		}

		return index;
	}

}
