package uber;

import java.util.Stack;

public class SolveEquation {

	public static void main(String[] args) {
		String s = "2x+3x-6x=x+2"; //"2x=x";//
		String result = solveEquation(s);
		System.out.println(result);
		
		int result2 = solveEquation2(s);
		System.out.println(result2);
	}
	
	
	
	

	private static int solveEquation2(String s) {
		String[] parts = s.split("=");
		int[] left = solve(parts[0]);
		int[] right = solve(parts[1]);
		int x = left[0] - right[0], val = right[1] - left[1];
		return val/x;
	}

	//2x+3x-6x
	private static int[] solve(String s) {
		int x = 0, val = 0;
		
		for(int i = 0; i < s.length(); i++) {
			StringBuilder sb = new StringBuilder();
			if(s.charAt(i) == '-') {
				sb.append("-");
				if(i < s.length() - 1 && s.charAt(i + 1) - '0' >= 0 && s.charAt(i + 1) - '0' <= 9) {
					while(s.charAt(i) != '-' || s.charAt(i) != '+' || s.charAt(i) != 'x') {
						sb.append(s.charAt(i));
						i++;
					}
					if(s.charAt(i) == '-' || s.charAt(i) == '+') {
						val += Integer.parseInt(sb.toString());
					} else {
						x += Integer.parseInt(sb.toString());
					}
				} else if(i < s.length() - 1 && s.charAt(i + 1) == 'x') {
					x += -1;
				}
			} else {
				if(i < s.length() - 1 && s.charAt(i + 1) - '0' >= 0 && s.charAt(i + 1) - '0' <= 9) {
					while(s.charAt(i) != '-' || s.charAt(i) != '+' || s.charAt(i) != 'x') {
						sb.append(s.charAt(i));
						i++;
					}
					if(s.charAt(i) == '-' || s.charAt(i) == '+') {
						val += Integer.parseInt(sb.toString());
					} else {
						x += Integer.parseInt(sb.toString());
					}
				} else if(i < s.length() - 1 && s.charAt(i + 1) == 'x') {
					x += 1;
				}
			}
		}
		
		return new int[] {x, val};
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
