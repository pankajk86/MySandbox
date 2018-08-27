package google;

public class SwapAdjLRString {

	public static void main(String[] args) {
		String start = "XXRXXLXXXX", end = "XXXXRXXLXX";  // RXXLXLRXX
		boolean result = canTransformCorrect(start, end);
		System.out.println(result);
	}
	
	private static boolean canTransformCorrect(String a, String b) {
		if(a.length() != b.length()) return false;
		if(!a.replaceAll("X", "").equals(b.replaceAll("X", ""))) return false;
		
		int p1 = 0, p2 = 0;
		char[] c1 = a.toCharArray(), c2 = b.toCharArray();
		
		while(p1 < c1.length) {
			while(p1 < c1.length && c1[p1] == 'X') p1++;
			while(p2 < c2.length && c2[p2] == 'X') p2++;
			
			// if one reach the end, the other one must reach the end too, since we have already check their order first.
			if(p1 == c1.length || p2 == c2.length) return true;
			
			if(c1[p1] == 'R' && p1 > p2) return false;
			if(c1[p1] == 'L' && p1 < p2) return false;
			p1++;
			p2++;
		}
		
		return true;
		
		
	}

	@SuppressWarnings("unused")
	private static boolean canTransform(String a, String b) {

		if(a == null || b == null)
			return false;
		
		if(a.length() != b.length())
			return false;
		
		for(int i = 0; i < a.length(); ) {
			if(a.charAt(i) == b.charAt(i)) {
				i++;
			} else {
				
				String tempa = "", tempb = "";
				
				if(i < a.length() - 2) {
					tempa = a.substring(i, i + 2);
					tempb = b.substring(i, i + 2);

				} else {
					tempa = a.substring(i);
					tempb = b.substring(i);
				}
				
				if((tempa.equals("RX") && tempb.equals("XR"))
						|| (tempa.equals("XL") && tempb.equals("LX"))) {
					i += 2;
				} else {
					return false;
				}
			}
		}
		return true;
	}

}
