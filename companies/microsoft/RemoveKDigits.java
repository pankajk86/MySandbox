package microsoft;

public class RemoveKDigits {

	public static void main(String[] args) {
		String s = "1432219";
		int k = 3;
		String result = removeKDigits(s, k);
		System.out.println(result);
	}

	private static String removeKDigits(String s, int k) {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			while(k > 0 && sb.length() > 0 && sb.charAt(sb.length() - 1) > c) {
				sb.deleteCharAt(sb.length() - 1);
				k--;
			}
			
			if(sb.length() == 0 && c == '0') continue;
			sb.append(c);
		}
		
		while(k-- > 0 && sb.length() > 0)
			sb.deleteCharAt(sb.length() - 1);
		
		return sb.length() == 0 ? "0" : sb.toString();
	}

}
