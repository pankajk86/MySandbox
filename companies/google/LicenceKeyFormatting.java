package google;

public class LicenceKeyFormatting {

	public static void main(String[] args) {
		String s = "5F3Z-2e-9-w";
		int k = 4;
		
		String result = format(s, k);
		System.out.println(result);
	}

	private static String format(String s, int k) {
		
		s = s.replace("-", "").toUpperCase();
		StringBuilder sb = new StringBuilder();
		
		int firstPart = s.length() % k;
		int i = 0;
		
		if(firstPart > 0) {
			sb.append(s.substring(0, firstPart) + "-");
			i = firstPart;
		}
		
		for(int j = i; j < s.length(); j = j + k) {
			sb.append(s.substring(j, j + k) + "-");
		}
		
		return sb.length() > 0 ? sb.substring(0, sb.length() - 1).toString() : sb.toString();
	}

}
