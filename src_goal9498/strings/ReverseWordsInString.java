package strings;

public class ReverseWordsInString {

	public static void main(String[] args) {
		String s = "   a   b ";
		String reverse = reverse(s);
		System.out.println("-" + reverse + "-");
	}

	private static String reverse(String s) {
		
		if(s.trim().equals("")) {
            return "";
        }
        
        char[] sarr = s.replaceAll("\\s+", " ").trim().toCharArray();
		reverse(sarr, 0, sarr.length - 1);

		int i = 0;

		for (int j = 0; j < sarr.length; j++) {
			if (sarr[j] == ' ') {
				reverse(sarr, i, j - 1);
				i = j + 1;
			}
		}
		
		reverse(sarr, i, sarr.length-1);

		return String.valueOf(sarr);
	}

	private static void reverse(char[] sarr, int start, int end) {

		for (int i = start, j = end; i < j; i++, j--) {
			char c = sarr[i];
			sarr[i] = sarr[j];
			sarr[j] = c;
		}
	}

}
