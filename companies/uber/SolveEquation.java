package uber;

import java.util.Stack;

public class SolveEquation {

	public static void main(String[] args) {
		String s = "-x=-1"; //"2x=x";//
		String result = solveEquation(s);
		System.out.println(result);
	}

	private static String solveEquation(String s) {

		String[] sides = s.split("=");
		int[] left = simplify(sides[0]); // 2x + 2 = x + 4
		int[] right = simplify(sides[1]); // x + 4
		int value = 0;
		String message = null;
		
		if(left[0] > right[0]) {
			value = (right[1] - left[1]) / (left[0] - right[0]);
		} else if(left[0] < right[0]) {
			value = (left[1] - right[1]) / (right[0] - left[0]);
		} else {
			if(left[1] == right[1])
				message = "Infinite solutions";
			else
				message = "No solution";
		}
		
		if(message != null)
			return message;
		else
			return "x=" + value;
	}

	private static int[] simplify(String s) {
		
		Stack<Integer> xstack = new Stack<>();
		Stack<Integer> nstack = new Stack<>();
		int[] coeff = new int[2];
		
		char sign = '+';
		int num = 0;
		
		for(int i = 0; i < s.length(); i++) {
			char current = s.charAt(i);
			
			if(Character.isDigit(current)) {
				num = num * 10 + (current - '0');
			}
			
			if(!Character.isDigit(current) || i == s.length() - 1) {
				if(sign == '+')
					nstack.push(num);
				if(sign == '-')
					nstack.push(num);
				if(sign == 'x') {
					int n = nstack.pop();
					xstack.push(n == 0 ? 1 : n);
				}
				
				sign = current;
				num = 0;
			}
		}
		
		if(sign == 'x') {
			int n = nstack.pop();
			xstack.push(n == 0 ? 1 : n);
		}
		
		while(!xstack.isEmpty()) {
			coeff[0] += xstack.pop();
		}
		
		while(!nstack.isEmpty()) {
			coeff[1] += nstack.pop();
		}
		
		return coeff;
	}

}
