package goal.algorithms.strings;

import java.util.HashMap;
import java.util.Map;

public class PangramCheck {

	public static void main(String[] args) {
		String str = "We promptly judgEd antique ivory buckles for the next prize";
		boolean result = checkPangram(str);
		System.out.println(str + " is pangram?: " + result);
		
	}

	private static boolean checkPangram(String str) {
		char[] arr = str.toLowerCase().toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(char c: arr) {
			int intVal = c;
			boolean isAscii = (intVal>=65 && intVal <= 90) || (intVal>=97 && intVal <= 122);
			if(!map.containsKey(c) && isAscii) {
				map.put(c, 1);
			}
		}
		
		if(map.size() == 26) {
			return true;
		}
		
		return false;
	}

}
