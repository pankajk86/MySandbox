package linkedin;

public class ReplaceStringWithAnotherInYetAnother {

	public static void main(String[] args) {
		String orig = "abcdefcd", find = "cd", repl = "xl";
		String result = replace(orig, find, repl);
		System.out.println(result);
	}

	private static String replace(String orig, String find, String repl) {
		int findLength = find.length();
		
		if(findLength == 0) throw new IllegalArgumentException("find can't be empty.");
		if(find.equals(repl)) return orig;
		int found = orig.indexOf(find);
		if(found == -1) return orig;
		
		StringBuilder result = new StringBuilder();
		char[] carr = orig.toCharArray();
		int index = 0;
		
		while(found != -1) {
			result.append(carr, index, found - index);
			result.append(repl);
			index = found + findLength;
			found = orig.indexOf(find, index);
		}
		
		result.append(carr, index, orig.length() - index);
		return result.toString();
	}

}
