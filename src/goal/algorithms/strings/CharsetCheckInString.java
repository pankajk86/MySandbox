package goal.algorithms.strings;

public class CharsetCheckInString {

	public static void main(String[] args) {
		String INPUT = "pankajkumar";
		String CHARS  = "jakn";
		
		String minWindow = getCharsetMinWindow(INPUT, CHARS);
		System.out.println("Mininum window for " + CHARS + " in " + INPUT + " : " + minWindow);
	}

	private static String getCharsetMinWindow(String input, String chars) {
		
		int charsHashCode = 1;
		int charsLen = chars.length();
		
		for(int i=0; i< charsLen; i++) {
			char c = chars.charAt(i);
			charsHashCode *= Characters.valueOf(String.valueOf(c)).getPrimeCode();
		}
		
		int minHashCode = 1;
		int j = 0;
		
		for(int i=0; i<=input.length()-charsLen; i++) {				
			
			if(i == 0) {	
				j = i;
				for(; j<(i+charsLen); j++) {
					char c = input.charAt(j);
					minHashCode *= Characters.valueOf(String.valueOf(c)).getPrimeCode();
				}
			}
				
			if(minHashCode == charsHashCode) {
				return input.substring(i, i+charsLen);
			} else {	
				minHashCode /= Characters.valueOf(String.valueOf(input.charAt(i))).getPrimeCode();
				minHashCode *= Characters.valueOf(String.valueOf(input.charAt(j))).getPrimeCode();
				j++;
			}
		}
		
		return null;
	}

}
