package facebook;

public class OneEditDistance {

	public static void main(String[] args) {
		String s = "a", t = "";
		boolean result = isOneEditDistance(s, t);
		System.out.println(result);
	}

	private static boolean isOneEditDistance(String s, String t) {
		int l1 = s.length(), l2 = t.length();
		
		if(Math.abs(l1 - l2) > 1) return false;
		int count = 0;
		s = s + ")";
		t = t + ")";
		l1 = s.length(); l2 = t.length();
		
		for(int i = 0, j = 0; i < l1 && j < l2; ) {
			if(s.charAt(i) != t.charAt(j)) {
				if(i == l1 - 1 || j == l2 - 1) {
					return count < 1;
				}
				if(s.charAt(i + 1) == t.charAt(j)) {
					i++;
				} else if(s.charAt(i) == t.charAt(j + 1)) {
					j++;
				} else if(s.charAt(i + 1) == t.charAt(j + 1)) {
					i++; j++;
				} else return false;
				count++;
			} 
			i++; j++;
		}
		
		return count == 1;
	}

}
