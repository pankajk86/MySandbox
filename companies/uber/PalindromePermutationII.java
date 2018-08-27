package uber;

import java.util.ArrayList;
import java.util.List;

public class PalindromePermutationII {

	private static List<String> result = new ArrayList<>();
	
	public static void main(String[] args) {
		String s = "aabb";
		List<String> result = generatePermutations(s);
		
		for(String p: result)
			System.out.println(p);
	}

	private static List<String> generatePermutations(String s) {

		int numOdds = 0;
		int[] map = new int[256]; // map from character to frequency
		for(char c: s.toCharArray()) {
			map[c]++;
			numOdds = (map[c] & 1) == 1 ? numOdds + 1 : numOdds - 1;
		}
		
		if(numOdds > 1) return result;
		
		String mid = "";
		int length = 0;
		
		for(int i = 0; i < 256; i++) {
			if(map[i] > 0) {
				if((map[i] & 1) == 1) { // char with odd count in the middle
					mid = "" + (char) i;
					map[i]--;
				}
				map[i] /= 2; // cut in half as we only need half the string
				length += map[i]; 
			}
		}
		
		generatePalindromeHelper(map, length, "", mid);
		return result;
	}

	private static void generatePalindromeHelper(int[] map, int length, String s, String mid) {
		if(s.length() == length) {
			StringBuilder sb = new StringBuilder(s).reverse();
			result.add(s + mid + sb);
		}
		
		for(int i = 0; i < 256; i++) {
			if(map[i] > 0) {
				map[i]--;
				generatePalindromeHelper(map, length, s + (char)i, mid);
				map[i]++;
			}
		}
	}

}
