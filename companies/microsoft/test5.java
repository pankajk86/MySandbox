package microsoft;

import java.util.Random;

public class test5 {

	public static void main(String[] args) {
		String s = "rd?e?wg??";
		String result = test(s);
		System.out.println(result);
	}

	private static String test(String s) {
		
		char[] carr = s.toCharArray();
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '?')
				replace(carr, i);
		}
		
		return String.valueOf(carr);
	}
	
	private static void replace(char[] carr, int i) {
		Random rand = new Random();
		char c;
		
		do {
			c = (char) ('a' + rand.nextInt(26));
		} while((i > 0 && carr[i - 1] == c) || (i < carr.length - 1 && carr[i + 1] == c));
		
		carr[i] = c;
	}

}