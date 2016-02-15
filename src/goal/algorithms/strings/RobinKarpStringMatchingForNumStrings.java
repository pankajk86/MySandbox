package goal.algorithms.strings;

public class RobinKarpStringMatchingForNumStrings {

	public static void main(String[] args) {
		String text = "123456789";
		String pattern = "5678";
		
		int startLoc = searchPattern(text, pattern);
		System.out.println("Starting Location of the pattern in text: " + startLoc);
	}

	private static int searchPattern(String text, String pattern) {
		
		int n = text.length();
		int m = pattern.length();
		int patternInt = Integer.parseInt(pattern);
		
		// we need not to go till the end of the text, as we just interested in find the pattern.
		// so, at max, we will go to (n-(m-1)), i.e. (n-m+1).
		for(int i=0; i<(n-m+1); i++) {
			String subText = text.substring(i, i+m);
			int textPartInt = Integer.parseInt(subText);
			if(textPartInt == patternInt) {
				return i;
			}
		}
		
		return -1;
	}

}
