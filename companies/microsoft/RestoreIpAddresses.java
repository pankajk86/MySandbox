package microsoft;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {

	public static void main(String[] args) {
		String s = "010010";//"25525511135"; // "0279245587303"; //
		List<String> result = restoreIpAddresses(s);
		System.out.println(result);
	}

	private static List<String> restoreIpAddresses(String s) {

		List<String> result = new ArrayList<>();
		
		if(s == null || s.isEmpty() || s.length() > 12)
			return result;

		for (int a = 1; a <= 3; a++) {
			for (int b = 1; b <= 3; b++) {
				for (int c = 1; c <= 3; c++) {

					if(a + b + c < s.length()) {
						String A = s.substring(0, a);
						String B = s.substring(a, a + b);
						String C = s.substring(a + b, a + b + c);
						String D = s.substring(a + b + c);
						
						if(!checkStartWithZero(A, B, C, D)) {
							if (Long.parseLong(A) <= 255  
									&& Long.parseLong(B) <= 255 
									&& Long.parseLong(C) <= 255
									&& Long.parseLong(D) <= 255) {
								
								String temp = A + "." + B + "." + C + "." + D;
								if (temp.length() == s.length() + 3)
									result.add(temp);
							}
						}
					}
				}
			}
		}
		return result;
	}
	
	private static boolean checkStartWithZero(String a, String b, String c, String d) {
		return (a.startsWith("0") && a.length() > 1)
				|| (b.startsWith("0") && b.length() > 1)
				|| (c.startsWith("0") && c.length() > 1)
				|| (d.startsWith("0") && d.length() > 1);
	}

}
