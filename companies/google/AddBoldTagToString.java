package google;

public class AddBoldTagToString {

	public static void main(String[] args) {
		String s = "aaabbcc";
		String[] dict = {"aaa", "aab", "bc"};
		String result = addBoldTag(s, dict);
		System.out.println(result);
	}

	private static String addBoldTag(String s, String[] dict) {

		boolean[] bold = new boolean[s.length()];
		
		for(int i = 0, end = 0; i < s.length(); i++) {
			for(String word: dict) {
				if(s.startsWith(word, i))
					end = Math.max(end, i + word.length());
			}
			bold[i] = end > i;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < s.length(); i++) {
			if(!bold[i])
				sb.append(s.charAt(i));
			else {
				int j = i;
				while(j < s.length() && bold[j])
					j++;
				sb.append("<b>" + s.substring(i, j) + "</b>");
				i = j - 1;
			}
		}
		
		return sb.toString();
	}

}
