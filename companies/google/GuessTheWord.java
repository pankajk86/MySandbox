package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GuessTheWord {

	private static Random rand = new Random();
	
	public static void main(String[] args) {
		String secret = "acczzb";
		String[] wordlist = { "acckzz", "ccbazz", "kfddlf", "ccdbaz", "acczzb", "eiowzz", "abcczz" };
		Master master = new Master(secret);
		
		int[] result = findSecretWord(wordlist, master);  // how many guesses, did we succeed (0: No/1: Yes)
		System.out.println(Arrays.toString(result));
	}

	private static int[] findSecretWord(String[] wordlist, Master master) {
		int i = 0, matches = 0;
		
		for(; i < 10 && matches < 6; i++) {
			String word = wordlist[rand.nextInt(wordlist.length)];
			matches = master.guess(word);
			
			List<String> newList = new ArrayList<>();
			for(String w: wordlist) {
				if(matchCount(w, word) == matches)
					newList.add(w);
			}
			wordlist = newList.toArray(new String[newList.size()]);
		}
		return new int[] {i, matches == 6 ? 1 : 0};
	}

	private static int matchCount(String w1, String w2) {
		int result = 0;
		
		for(int i = 0; i < w1.length(); i++)
			result += w1.charAt(i) == w2.charAt(i) ? 1 : 0;
		
		return result;
	}

}

class Master {
	private String secret;
	
	Master(String secret) {
		this.secret = secret;
	}
	
	public int guess(String word) {
		int result = 0;
		
		for(int i = 0; i < word.length(); i++)
			result += secret.charAt(i) == word.charAt(i) ? 1 : 0;
		
		return result;
	}
}