package strings;

import java.util.HashMap;
import java.util.Map;

public class IntegerToEnglishWords {

	public static void main(String[] args) {
		int n = 123;
		String result = numberToWords(n);
		System.out.println(result);
	}

	private static String numberToWords(int n) {
		
		if(n == 0) {
			return "Zero";
		}

		StringBuilder result = new StringBuilder();
		int i = 0;
		
		while(n > 0) {
			int part = n % 1000;
			StringBuilder partWords = getPartWords(part, i);
			result = partWords.length() > 0 ? partWords.append(" ").append(result) : result;
			n /= 1000; i++;
		}
		
		return result.toString().trim();
	}

	private static StringBuilder getPartWords(int n, int i) {

		StringBuilder sb = new StringBuilder();
		Map<Integer, String> map = getIntToWordMap();

		if(n >= 10 && n <= 20) {
			sb.append(map.get(n)).append(" ");
		} else {
			int j = 1;
			StringBuilder temp;
			
			while(n > 0) {
				
				int part = n % 10;
				if(part != 0) {
					if(j % 3 == 1) {
						temp = new StringBuilder(map.get(part));
						sb = temp.append(" " + sb);
					} else if(j % 3 == 2) {
						temp = new StringBuilder(map.get(part * 10));
						sb = temp.append(" " + sb);
					} else if(j % 3 == 0) {
						temp = new StringBuilder(map.get(part));
						sb = temp.append(" Hundred").append(" " + sb);
					}
				}
				j++; n /= 10;

			}
		}
		
		if(sb.length() > 0) {
			if(i == 1) 
				sb.append("Thousand");
			else if(i == 2) 
				sb.append("Million");
			else if(i == 3) 
				sb.append("Billion");
		}
		
		return sb;
	}

	private static Map<Integer, String> getIntToWordMap() {

		Map<Integer, String> map = new HashMap<>();
		map.put(0, "Zero");
		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");
		map.put(4, "Four");
		map.put(5, "Five");
		map.put(6, "Six");
		map.put(7, "Seven");
		map.put(8, "Eight");
		map.put(9, "Nine");
		map.put(10, "Ten");
		
		map.put(11, "Eleven");
		map.put(12, "Twelve");
		map.put(13, "Thirteen");
		map.put(14, "Fourteen");
		map.put(15, "Fifteen");
		map.put(16, "Sixteen");
		map.put(17, "Seventeen");
		map.put(18, "Eighteen");
		map.put(19, "Nineteen");
		
		map.put(20, "Twenty");
		map.put(30, "Thirty");
		map.put(40, "Forty");
		map.put(50, "Fifty");
		map.put(60, "Sixty");
		map.put(70, "Seventy");
		map.put(80, "Eighty");
		map.put(90, "Ninety");
		
		return map;
	}

}
