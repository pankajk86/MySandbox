package google;

import java.util.ArrayList;
import java.util.List;

public class ShortestDistanceToCharacter {

	public static void main(String[] args) {
		String s = "loveleetcode";
		char c = 'e';
		
		int[] result = shortestDistance(s, c);
		for(int i: result) System.out.print(i + " ");
	}

	private static int[] shortestDistance(String s, char c) {
		int[] result = new int[s.length()];
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == c) list.add(i);
		}
		
		for(int i = 0, j = 0; i < s.length(); i++) {
			if(i <= list.get(0)) {
				result[i] = list.get(0) - i;
				if(i == list.get(0)) j++;
			} else if(i >= list.get(list.size() - 1)) {
				result[i] = i - list.get(list.size() - 1);
			} else {
				if(i < list.get(j))
					result[i] = Math.min(list.get(j) - i, i - list.get(j - 1));
				else j++;
			}
		}
		
		return result;
	}

}
