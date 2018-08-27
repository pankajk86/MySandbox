package google;

import java.util.Arrays;

public class StraightHands {

	public static void main(String[] args) {
		int[] hand = { 2, 1 };
		int w = 2;
		boolean result = isStraightHand(hand, w);
		System.out.println(result);
	}

	private static boolean isStraightHand(int[] hand, int w) {

		int[] curr = new int[w];
		int[] cap = new int[w];
		int index = 0;
		
		Arrays.sort(hand);
		
		for(int i = 0; i < hand.length; ) {
			for(int j = index; j < w; ) {
				if(curr[j] == 0 || (hand[i] - curr[j] == 1 && cap[j] < w)) {
					curr[j] = hand[i]; cap[j]++;
					
					if(cap[j] == w) {
						index++;
					}
					
					break;
				} else {
					j++;
				}
			}
			i++;
		}

		for(int i: cap) {
			if(i < w)
				return false;
		}
		
		return true;
	}

}
