package uber;

import java.util.Stack;

public class EvaluateStringExpressionII {

	public static void main(String[] args) {
		String s = "2-(5-6)"; //"((1+(4+5+2)-3)+(6+8)) - (4)";
		int result = calculate(s);
		System.out.println(result);
		
		result = calculateAnother(s);
		System.out.println(result);
	}

	private static int calculate(String s) {

		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < s.length(); i++) {
			char current = s.charAt(i);
			
			if(current != ')')
				stack.push(current);
			else {
				String temp = "";

				while(stack.peek() != '(') {
					temp = stack.pop() + temp;
				}
				stack.pop();
				int inter = evaluate(temp);
				
				for(char c: String.valueOf(inter).toCharArray())
					stack.push(c);
				
			}
		}
		
		String temp = "";
		
		while(!stack.isEmpty())
			temp = stack.pop() + temp;
		
		int result = evaluate(temp);
		
		return result;
	}

	private static int evaluate(String temp) {
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < temp.length(); i++) {
			if(i < temp.length() - 1 && temp.charAt(i) == '-' && temp.charAt(i + 1) == '-') {
				sb.append('+');
				i++;
			} else {
				sb.append(temp.charAt(i));
			}
		}
		
		temp = sb.toString();

		Stack<Integer> stack = new Stack<>();
		int num = 0;
		char sign = '+';
		
		for(int i = 0; i < temp.length(); i++) {
			char current = temp.charAt(i);
			
			if(Character.isDigit(current)) {
				num = num * 10 + (current - '0');
			}
			
			if((!Character.isDigit(current) && current != ' ') || i == temp.length() - 1) {
				if(sign == '+')
					stack.push(num);
				
				if(sign == '-')
					stack.push(-num);
				
				sign = current;
				num = 0;
			}
		}
		
		int result = 0;
		
		while(!stack.isEmpty())
			result += stack.pop();
		
		return result;
	}
	
	
	public static int calculateAnother(String s) {
		int len = s.length(), sign = 1, result = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < len; i++) {
			if (Character.isDigit(s.charAt(i))) {
				int sum = s.charAt(i) - '0';
				while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
					sum = sum * 10 + s.charAt(i + 1) - '0';
					i++;
				}
				result += sum * sign;
			} else if (s.charAt(i) == '+')
				sign = 1;
			else if (s.charAt(i) == '-')
				sign = -1;
			else if (s.charAt(i) == '(') {
				stack.push(result);
				stack.push(sign);
				result = 0;
				sign = 1;
			} else if (s.charAt(i) == ')') {
				result = result * stack.pop() + stack.pop();
			}

		}
		return result;
	}

}
