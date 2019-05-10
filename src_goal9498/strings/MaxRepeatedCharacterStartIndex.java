package strings;

public class MaxRepeatedCharacterStartIndex {

	public static void main(String[] args) {
		String s = "abbacddd";
		int result = getStartIndexOfMaxRepeatedCharacter(s);
		System.out.println(result);
	}

	private static int getStartIndexOfMaxRepeatedCharacter(String s) {

		if (s == null || s.isEmpty())
			return -1;

		int i = 0, j = 0, result = 0, maxLength = 0;

		while (j < s.length() - 1) {
			if (s.charAt(j) == s.charAt(j + 1))
				j++;
			else {
				int length = j - i + 1;
				if(length > maxLength) {
					maxLength = length;
					result = i;
				}
				i = j + 1;
				j = i;
			}
		}

		int length = j - i + 1;
		if(length > maxLength) {
			maxLength = length;
			result = i;
		}

		return result;
	}

}
