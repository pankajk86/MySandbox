package strings;

public class RollCharactersInString {

	public static void main(String[] args) {
		String s = "zcza";
		int[] roll = {1, 1, 3, 4 };
		
		String result = rollCharacters(s, roll);
		System.out.println(result);
	}

	private static String rollCharacters(String s, int[] roll) {

		int[] temp = new int[s.length()];
		
		for(int i = 0; i < roll.length; i++) {
			for(int j = 0; j < roll[i]; j++) {
				temp[j]++;
			}
		}
		
		char[] carr = s.toCharArray();
		
		for(int i = 0; i < carr.length; i++) {
			int rolled = (carr[i] - 'a' + 1) + temp[i];
			carr[i] = (char) ('a' - 1 + (rolled % 26));
		}
		
		return String.valueOf(carr);
	}

}
