package strings;

public class ZigZagConversion {

	public static void main(String[] args) {
		String s = "ABCDEFGHIJKLMNOPQRST";
		int rows = 5;
		String result = convert(s, rows);
		System.out.println(result);
	}

	private static String convert(String s, int rows) {
		
		if(s.isEmpty() || s == null || rows == 1 || s.length() == rows) {
			return s;
		}
		
		char[] carr = s.toCharArray();
		
		StringBuilder result = new StringBuilder();
		StringBuilder[] sbs = new StringBuilder[rows];
		
		for(int i = 0; i < sbs.length; i++) {
			sbs[i] = new StringBuilder();
		}
		
		int j = 0, flag = 0;
		
		for(int i = 0; i < carr.length;) {
			if(flag == 0) {
				for(j = 0; j < rows; j++) {
					if(i < carr.length)
						sbs[j].append(carr[i++]);
				}
				if(j == rows) {
					flag = 1;
				}
			} else {
				for(j = rows - 2; j >= 1; j--) {
					if(i < carr.length)
						sbs[j].append(carr[i++]);
				}
				if(j == 0) {
					flag = 0;
				}
			}
		}
		
		for(StringBuilder sb: sbs) {
			result.append(sb);
		}
		
		return result.toString();
	}

	@SuppressWarnings("unused")
	private static char[] reverseMiddle(char[] carr, int rows) {

		for(int i = 0, j = 1; i < carr.length;) {
			if(j == rows) {
				if(rows + i - 2 < carr.length) {
					int start = i + 1, end = i + rows - 2;
					while(start < end) {
						char t = carr[start];
						carr[start] = carr[end];
						carr[end] = t;
						start++; end--;
					}
					i = i + rows -1; j = 1;
				} else {
					i++; j++;
				}
			} else {
				i++; j++;
			}
		}
		
		return carr;
	}

}
