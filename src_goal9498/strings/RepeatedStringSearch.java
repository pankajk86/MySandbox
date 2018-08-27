package strings;

public class RepeatedStringSearch {

	public static void main(String[] args) {
		String a = "abcd", b = "cdabcdab";
		int result = repeatedString(a, b);
		System.out.println(result);
		
		result = repeated(a, b);
		System.out.println(result);
	}
	
	private static int repeated(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int count = 0;
		
		while(sb.length() < b.length()) {
			sb.append(a); count++;
		}
		
		if(sb.toString().contains(b)) return count;
		if(sb.append(a).toString().contains(b)) return count + 1;
		return -1;
	}

	private static int repeatedString(String a, String b) {

		int i = 0, j = 0, result = 1;
		
		while(i < a.length() && j < b.length()) {
			if(a.charAt(i) == b.charAt(j)) {
				i++; j++;
			} else {
				i++;
				
				if(j > 0) {
					result = -1;
					break;
				}
			}
			
			if(i == a.length() && j < b.length()) {
				a += a; result++;
			}
		}
		
		return result;
	}

}
