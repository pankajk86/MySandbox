package uber;

public class SolveEquation {

	public static void main(String[] args) {
		String s = "2x+3x-6x=x+2";
		String result = solveEquation(s);
		System.out.println(result);
	}
	
	private static String solveEquation(String s) {
		String[] parts = s.split("=");
		int[] left = solve(parts[0]);
		int[] right = solve(parts[1]);
		int x = left[0] - right[0], val = right[1] - left[1];
		
		if(x == 0) return "Infinite solutions";
		else return "x=" + (val/x);
	}

	//2x+3x-6x
	private static int[] solve(String s) {
		int[] result = new int[2];
		String[] elements = s.split("(?=[-+])");
		
		for(String e: elements) {
			if(e.equals("x") || e.equals("+x")) 
				result[0]++;
			else if(e.equals("-x")) 
				result[0]--;
			else if(e.contains("x"))
				result[0] += Integer.parseInt(e.substring(0, e.indexOf("x")));
			else
				result[1] += Integer.parseInt(e);
		}
		
		return result;
	}

}
