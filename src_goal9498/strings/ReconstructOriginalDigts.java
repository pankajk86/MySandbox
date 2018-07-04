package strings;

public class ReconstructOriginalDigts {

	public static void main(String[] args) {
		String s = "xsi";
		String digits = reconstructDigits(s);
		System.out.println(digits);
	}

	private static String reconstructDigits(String s) {

		StringBuilder result = new StringBuilder();
		int[] count = new int[26];
		
		for(int i=0; i< s.length(); i++) {
			count[s.charAt(i) - 'a']++;
		}
		
		int[] num = new int[10];
		
		num[0] = count['z' - 'a'];
		num[2] = count['w' - 'a'];
		num[4] = count['u' - 'a'];
		num[6] = count['x' - 'a'];
		num[8] = count['g' - 'a'];
		
		num[1] = count['o' - 'a'] - num[0] - num[2] - num[4];
		num[3] = count['h' - 'a'] - num[8];
		num[5] = count['f' - 'a'] - num[4];
		num[7] = count['s' - 'a'] - num[6];
		num[9] = count['i' - 'a'] - num[5] - num[6] - num[8];
		
		for(int i=0; i<10; i++) {
			for(int j=0; j<num[i]; j++) {
				result.append(i);
			}
		}
		
		return result.toString();
	}

}
