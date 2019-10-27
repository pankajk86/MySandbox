package microsoft;

public class test4 {

	public static void main(String[] args) {
		String s = "aadaaad";
		int left = 0, right = 0;
		
		StringBuilder sb = new StringBuilder();
		while( right < s.length() ) {
			while(s.charAt(right) == s.charAt(left)) {
				right++;
				if(right == s.length()) break;
			}
			if(right - left < 3) {
				while(left < right) sb.append(s.charAt(left++));
			} else {
				sb.append(s.charAt(left++)).append(s.charAt(left++));
				left = right;
			}
			
			if(right >= s.length() - 1) break;
		}
		
		if(left < s.length()) {
			if(right - left < 3) {
				while(left <= right) sb.append(s.charAt(left++));
			} else {
				sb.append(s.charAt(left++)).append(s.charAt(left++));
			}
		}
		
		System.out.println(sb.toString());
	}

}
