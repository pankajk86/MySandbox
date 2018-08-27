package google;

public class BackspaceStringCompare {

	public static void main(String[] args) {
		String s = "ab#c", t = "ad#c";
		boolean result = compare(s, t);
		System.out.println(result);
	}

	private static boolean compare(String s, String t) {

		String ss = process(s);
		String tt = process(t);
		
		return ss.equals(tt);
	}

	private static String process(String s) {

		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '#') {
				if(sb.length() > 0) {
					sb.deleteCharAt(sb.length() - 1);
				}
			} else {
				sb.append(s.charAt(i));
			}
		}
		
		return sb.toString();
	}

}
