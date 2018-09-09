package google;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsInString {

	public static void main(String[] args) {
		String s = ".,";
		String result = reverseVowels(s);
		System.out.println(result);
	}

	private static String reverseVowels(String s) {
		char[] carr = s.toCharArray();
		int i = 0, j = carr.length - 1;
		Set<Character> set = new HashSet<>();
		set.addAll(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
		
		while(i < j) {
			while(i < carr.length && !set.contains(carr[i])) 
				i++;
			while(j > 0 && !set.contains(carr[j])) 
				j--;
			
			if(i < j) {
				char temp = carr[i];
				carr[i] = carr[j];
				carr[j] = temp;
				i++; j--;
			}
		}
		
		return String.valueOf(carr);
	}

}
