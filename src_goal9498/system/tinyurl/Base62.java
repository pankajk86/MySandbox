public class Base62 {

	private static final String ALBHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static final int BASE = ALBHABET.length();

	public static void main(String args[]) {
		Long n = 100L;
		
		String tinyURL = id2TinyUrl(n);
		System.out.println(tinyURL);
		
		Long id = tinyUrl2Id(tinyURL);
		System.out.println(id);
	}
	
	public static String id2TinyUrl(Long n) {
		StringBuilder sb = new StringBuilder();

		while (n > 0) {
			int rem = (int) (n % BASE);
			sb.append(ALBHABET.charAt(rem));
			n /= BASE;
		}
		
		while(sb.length() < 6) {
			sb.append("0");
		}

		return sb.reverse().toString();
	}
	
	public static Long tinyUrl2Id(String s) {
		
		Long id = 0L;
		int start = 0;
		
		while(s.charAt(start) == '0') {
			start++;
		}
		
		s = s.substring(start);
		
		for(int i=s.length()-1, j = 0; i >= 0; i--, j++) {
			int n = ALBHABET.indexOf(s.charAt(i));
			id = (long) (id + n * Math.pow(BASE, j));
		}
		
		return id;
	}
}
