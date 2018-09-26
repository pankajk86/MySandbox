package arrays;

public class RectangleArea {

	public static void main(String[] args) {
		int A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2;
		int area = calculateArea(A, B, C, D, E, F, G, H);
		System.out.println(area);
	}

	private static int calculateArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		
		int independentTotalArea = ((A - C) * (B - D)) + ((E - G) * (F - H)); 

		if(A > G || E > C || B > H || F > D) 
			return independentTotalArea;
		
		int left = Math.max(A, E);
		int right = Math.min(C, G);
		int top = Math.min(D, H);
		int bottom = Math.max(B, F);
		
		return independentTotalArea - (left - right) * (bottom - top);
	}

}
