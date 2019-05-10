package facebook;

public class FirstUniqueCharacter {

	public static void main(String[] args) {
		String s = "loveleetcode";
		int result = getIndex(s);
		System.out.println(result);
	}

	private static int getIndex(String s) {
		int[] freq = new int[26];
		
		for(char c: s.toCharArray())
			freq[c - 'a']++;
		
		for(int i = 0; i < s.length(); i++) {
			if(freq[s.charAt(i) - 'a'] == 1)
				return i;
		}
		
		return -1;
	}

}
