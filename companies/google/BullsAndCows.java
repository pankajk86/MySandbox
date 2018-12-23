package google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BullsAndCows {

	public static void main(String[] args) {
		String secret = "1807", guess = "7810";
		String hint = getHint(secret, guess);
		System.out.println(hint);
		
		hint = getHintWithoutExtraSpace(secret, guess);
		System.out.println(hint);
	}
	
	private static String getHintWithoutExtraSpace(String secret, String guess) {
		
		int bulls = 0, cows = 0;
		int[] numbers = new int[10];
		
		
		for(int i = 0; i < secret.length(); i++) {
			int s = secret.charAt(i) - '0';
			int g = guess.charAt(i) - '0';
			
			if(s == g) bulls++;
			else {
				if(numbers[s] < 0) cows++;
				if(numbers[g] > 0) cows++;
				numbers[s]++;
				numbers[g]--;
			}
		}
		
		return bulls + "A" + cows + "B";
	}

	private static String getHint(String secret, String guess) {

		char[] cs = secret.toCharArray();
		char[] cg = guess.toCharArray();

		Map<Character, Integer> smap = new HashMap<>();
		Map<Character, Integer> gmap = new HashMap<>();
		
		List<Integer> bulls = new ArrayList<>();
		
		for(int i = 0, j = 0; i < cs.length; i++, j++) {
			smap.put(cs[i], smap.containsKey(cs[i]) ? smap.get(cs[i]) + 1 : 1);
			gmap.put(cg[j], gmap.containsKey(cg[j]) ? gmap.get(cg[j]) + 1 : 1);

			if(cs[i] == cg[j]) {
				bulls.add(cs[i] - '0');
				
				if(smap.containsKey(cs[i]))
					smap.put(cs[i], smap.get(cs[i]) - 1);
				
				if(gmap.containsKey(cg[j]))
					gmap.put(cg[j], gmap.get(cg[j]) - 1);
			}
		}
		
		int cows = 0;
		
		for(Map.Entry<Character, Integer> entry: smap.entrySet()) {
			char key = entry.getKey();
			if(gmap.containsKey(key) && gmap.get(key) > 0) {
				cows += Math.min(gmap.get(key), entry.getValue());
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(bulls.size()).append('A').append(cows).append('B');
		return sb.toString();
	}

}

