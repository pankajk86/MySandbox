package google;

public class StrobogrammaticNumber {

	public static void main(String[] args) {
		String s = "1601091";
		boolean result = isStrobogrammatic(s);
		System.out.println(result);
	}

	private static boolean isStrobogrammatic(String s) {
		if(s == null || s.isEmpty()) return false;
		
		for(int i = 0, j = s.length() - 1; i <=j; i++, j--) {
			char a = s.charAt(i), b = s.charAt(j);
			if((a == '0' && b == '0') || (a == '1' && b == '1') || (a == '8' && b == '8')
					|| (a == '6' && b == '9') || (a == '9' && b == '6'))
				continue;
			else return false;
				
		}
		return true;
	}

}
