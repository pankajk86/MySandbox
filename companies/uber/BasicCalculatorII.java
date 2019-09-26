package uber;

import java.util.Stack;

public class BasicCalculatorII {

	public static void main(String[] args) {
		String s = "3+12*2-4";
		int result = calculate(s);
		System.out.println(result);
		
		result = calculateConstantSpace(s);
		System.out.println(result);
	}
	
	private static int calculateConstantSpace(String s) {
		if(s == null) return 0;
		s += "+";
		int num = 0, sum = 0, prev = 0;
		char sign = '+';
		
		for(char c: s.toCharArray()) {
			if(c == ' ') continue;
			if(Character.isDigit(c)) num = num * 10 + (c - '0');
			else {
				if(sign == '+') {
					sum += prev; prev = num;
				} else if(sign == '-') {
					sum += prev; prev = -num;
				} else if(sign == '*') {
					prev *= num;
				} else if(sign == '/') {
					prev /= num;
				}
				sign = c;
				num = 0;
			}
		}
		return sum + prev;
	}

	private static int calculate(String s) {
		Stack<Integer> stack = new Stack<>();
		int num = 0, result = 0;
		char sign = '+';
		
		for(int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
			
			if(Character.isDigit(curr))
				num = num * 10 + (curr - '0');
			
			if((!Character.isDigit(curr) && curr != ' ') || i == s.length() - 1) {
				if(sign == '+') stack.push(num);
				if(sign == '-') stack.push(-num);
				if(sign == '*') stack.push(stack.pop() * num);
				if(sign == '/') stack.push(stack.pop() / num);
				
				sign = curr;
				num = 0;
			}
		}
		
		while(!stack.isEmpty())
			result += stack.pop();
		
		return result;
	}

}
