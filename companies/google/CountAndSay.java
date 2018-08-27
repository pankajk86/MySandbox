package google;

public class CountAndSay {

	public static void main(String[] args) {
		int n = 6;
		String result = countAndSay(n);
		System.out.println(result);
	}

	private static String countAndSay(int n) {

		String start = "1";
		
		for(int i = 1; i < n; i++) {
			start = getNext(start);
		}
		
		return start;
	}

	private static String getNext(String s) {

		StringBuilder sb = new StringBuilder();
		int count = 1;
		char c = s.charAt(0);
		
		for(int i = 1; i < s.length(); i++) {
			if(s.charAt(i) == c) {
				count++;
			} else {
				sb.append(count).append(c);
				count = 1; c = s.charAt(i);
			}
		}
		
		sb.append(count).append(c);
		return sb.toString();
	}

}
