package uber;

import java.util.Stack;

public class EvaluateStringExpression {

	public static void main(String[] args) {
		String expr = "-3+51 / 2 ";
		int result = calculate(expr);
		System.out.println(result);
	}

	private static int calculate(String s) {
		
		Stack<Integer> stack = new Stack<>();
		
		int num = 0;
		char sign = '+';
		
		for(int i = 0; i < s.length(); i++) {
			char current = s.charAt(i);
			
			if(Character.isDigit(current)) 
				num = num * 10 + (current - '0');
			
			if((!Character.isDigit(current) && current != ' ') || i == s.length() - 1) {
				if(sign == '+')
					stack.push(num);
				if(sign == '-')
					stack.push(-num);
				if(sign == '*')
					stack.push(stack.pop() * num);
				if(sign == '/')
					stack.push(stack.pop() / num);
				sign = current;
				num = 0;
			}
		}
		
		int result = 0;
		
		while(!stack.isEmpty())
			result += stack.pop();
		
		return result;
	}

}
