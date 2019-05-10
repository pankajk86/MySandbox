package microsoft;

public class ReverseWordsInStringIII {

	public static void main(String[] args) {
		String s = "Let's take LeetCode contest";
		String result = reverseWords(s);
		System.out.println(result);
	}

	private static String reverseWords(String s) {
		if(s == null || s.isEmpty()) return s;
		char[] carr = s.toCharArray();
		int i = 0, j = 0;
		
		for(; j < carr.length; j++) {
			if(carr[j] == ' ') {
				reverseWord(carr, i, j - 1);
				i = j + 1;
			}
		}
		reverseWord(carr, i, j - 1);
		return String.valueOf(carr);
	}

	private static void reverseWord(char[] carr, int start, int end) {
		for(int i = start, j = end; i <= j; i++, j--) {
			char temp = carr[i];
			carr[i] = carr[j];
			carr[j] = temp;
		}
	}

}
