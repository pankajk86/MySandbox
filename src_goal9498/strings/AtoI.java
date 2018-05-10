package strings;

public class AtoI {

	public static void main(String[] args) {
		String s = "- 204  ~   3";
		int number = atoi(s);
		System.out.println(number);
	}

	private static int atoi(String s) {

		s = s.replaceAll("\\s+", "");
		
		if(s.isEmpty()) {
			return 0;
		}

		char first = s.charAt(0);
		
		if(!isValidSign(first) && !isValidNumber(first)) {
			return 0;
		}
		
		int sign = 0, num = 0;
		
		if(first == '+') {
			sign = 1;
		} else if(first == '-') {
			sign = -1;
		}
		
		num = convert(s, sign);
		return num;
	}

	private static int convert(String s, int sign) {
		int num = 0, start = 0;
		Long rangeCheck = 0L;
		
		if(sign != 0) {
			start = 1;
		}
		
		int i = start, j = 0;
		
		while( i < s.length()) {
			if(!isValidNumber(s.charAt(i))) {
				break;
			}
			i++;
		}
		
		s = s.substring(start, i);

		for(i = s.length()-1, j = 0; i >= 0; i--, j++) {
			int n = Integer.parseInt(String.valueOf(s.charAt(i)));
			rangeCheck += n * (int) Math.pow(10, j);
		}
		
		if(sign == -1) {
			rangeCheck *= -1;
			if(rangeCheck < Integer.MIN_VALUE) {
				num = Integer.MIN_VALUE;
			} else {
				num = rangeCheck.intValue();
			}
		} else {
			if(rangeCheck > Integer.MAX_VALUE) {
				num = Integer.MAX_VALUE;
			} else {
				num = rangeCheck.intValue();
			}
		}
		
		return num;
	}

	private static boolean isValidNumber(char c) {
		return "0123456789".indexOf(c) >= 0;
	}

	private static boolean isValidSign(char c) {
		return (c == '+' || c == '-');
	}

}
