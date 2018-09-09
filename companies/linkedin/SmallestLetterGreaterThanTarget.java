package linkedin;

public class SmallestLetterGreaterThanTarget {

	public static void main(String[] args) {
		char[] letters = {'c', 'f', 'j'};
		char target = 'g';
		char result = nextGreatest(letters, target);
		System.out.println(result);
	}

	private static char nextGreatest(char[] letters, char target) {
		
		int iTarget = target - 'a';
		int n = letters.length;
		
		if(iTarget < letters[0] - 'a' || iTarget >= letters[n - 1] - 'a') 
			return letters[0];
		else {
			for(int i = 0; i < n - 1; i++) {
				if(iTarget >= letters[i] - 'a' && iTarget < letters[i + 1] - 'a')
					return letters[i + 1];
			}
		}
		
		return 0;
	}

}
