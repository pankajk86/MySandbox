package strings;

public class CheckAnagrams {

	public static void main(String[] args) {
		String a = "tablee", b = "beleat";
		boolean result = isAnagram(a, b);
		System.out.println(result);
	}

	private static boolean isAnagram(String a, String b) {
		if(a.length() != b.length()) return false;
		
		int[] freq = new int[26];
		
		for(int i = 0; i < a.length(); i++)
			freq[a.charAt(i) - 'a']++;
		
		for(int i = 0; i < b.length(); i++) {
			if(freq[b.charAt(i) - 'a'] == 0) return false;
			freq[b.charAt(i) - 'a']--;
		}
		
		return true;
	}

}
