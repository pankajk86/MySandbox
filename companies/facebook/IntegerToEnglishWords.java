package facebook;

public class IntegerToEnglishWords {

	private static String[] thousands = {"", " Thousand", " Million", " Billion"};
	private static String[] tens = {"", "", " Twenty", " Thirty", " Forty", " Fifty", 
			" Sixty", " Seventy", " Eighty", " Ninety"};
	private static String[] teens = {" Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", 
			" Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen"};
	private static String[] digits = {"", " One", " Two", " Three", " Four", " Five", " Six", 
			" Seven", " Eight", " Nine"};
	
	public static void main(String[] args) {
		int n = 1234567891;
		String result = numberToWords(n);
		System.out.println(result);
	}

	private static String numberToWords(int n) {
		StringBuilder sb = new StringBuilder();
		int index = 0;
		while(n > 0) {
			if(n % 1000 > 0) sb.insert(0, parse(n % 1000) + thousands[index]);
			n /= 1000;
			index++;
		}
		return sb.length() == 0 ? "Zero" : sb.substring(1);
	}

	private static Object parse(int n) {
		StringBuilder sb = new StringBuilder();
		if(n > 99) {
			sb.append(digits[n / 100]).append(" Hundred");
			n %= 100;
		}
		
		if(n > 19) {
			sb.append(tens[n / 10]); n %= 10;
		}
		
		if(n > 9) {
			sb.append(teens[n % 10]); return sb.toString();
		}
		
		sb.append(digits[n]); return sb.toString();
	}

}
