package google;

public class OutputContestMatches {

	public static void main(String[] args) {
		int n = 8;
		String result = findContestMatches(n);
		System.out.println(result);
	}

	private static String findContestMatches(int n) {
		String[] s = new String[n / 2];
		
		for(int i = 1, j = n; i < j; i++, j--)
			s[i - 1] = "(" + i + "," + j + ")";
		
		String[] temp = null;
		while(s.length > 2) {
			temp = new String[s.length / 2];
			for(int i = 0, j = s.length - 1; i < j; i++, j--)
				temp[i] = "(" + s[i] + "," + s[j] + ")";
			s = temp;
		}
		
		return s.length == 1 ? s[0] : "(" + s[0] + "," + s[1] + ")";
	}

}
