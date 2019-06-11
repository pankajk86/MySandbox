package apple;

public class ImplementLowerCase {

	public static void main(String[] args) {
		String s = "LOVELY";
		String result = toLowerCase(s);
		System.out.println(result);
	}

	private static String toLowerCase(String s) {
		if(s == null || s.isEmpty()) return s;
		
		char[] carr = s.toCharArray();
		for(int i = 0; i < carr.length; i++) {
			char c = s.charAt(i);
			if(c >= 'A' && c <= 'Z') {
				carr[i] = (char) ('a' + (c - 'A'));
			}
		}
		
		return String.valueOf(carr);
	}

}
