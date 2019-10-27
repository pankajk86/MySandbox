package microsoft;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class test1 {

	public static void main(String[] args) {
		String s = "aaBabcDaA";
		
		List<Character> lower = new ArrayList<>();
		List<Character> upper = new ArrayList<>();
		
		for(char c: s.toCharArray()) {
			if(c >= 'a' && c <= 'z') lower.add(c);
            if(c >= 'A' && c <= 'Z') upper.add(c);
		}
		
		Collections.sort(lower); Collections.sort(upper);
		String result = "NO";
		
		for(int i = lower.size() - 1, j = upper.size() - 1; i >= 0 && j >= 0; ) {
			char low = lower.get(i), up = upper.get(j), lowerUp = Character.toLowerCase(up);
			if(low == lowerUp) {
				result = String.valueOf(up);
				break;
			}
			else if(low < lowerUp) j--;
			else i--;
		}
		
		System.out.println(result);
	}

}
