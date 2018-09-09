package google;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PrintMatrixDiagonal {

	public static void main(String[] args) {
		int[][] a = {
				{1, 2, 3, 4, 7},
				{5, 1, 2, 3, 4},
				{9, 5, 1, 2, 3},
				{6, 9, 5, 1, 2}
			};
		
		List<List<Integer>> result = printDiagonally(a);
		
		for(List<Integer> diag: result)
			System.out.println(diag);
	}

	private static List<List<Integer>> printDiagonally(int[][] a) {
		int rows = a.length, cols = rows > 0 ? a[0].length : 0;
		int starti = 0, startj = cols - 1;
		int endi = 0, endj = cols - 1;
		Stack<List<Integer>> stack = new Stack<>();
		List<List<Integer>> result = new ArrayList<>();
		
		while(starti >= 0 && startj < cols && endi >= 0 && endj < cols) {
			List<Integer> list = new ArrayList<>();
			
			for(int i = starti, j = startj; (i <= endi && j <= endj); i++, j++) {
				list.add(a[i][j]);
			}
			stack.push(list);
			
			if(endi < rows - 1)
				endi++;
			else
				endj--;

			if(startj > 0) 
				startj--;
			else break;
			
		}
		
		while(!stack.isEmpty())
			result.add(stack.pop());
		
		
		starti = 1; startj = 0;
		while(starti < rows && startj < cols && endi >= 0 && endj < cols) {
			List<Integer> list = new ArrayList<>();
			
			for(int i = starti, j = startj; (i <= endi && j <= endj); i++, j++) {
				list.add(a[i][j]);
			}
			result.add(list);
			starti++; endj--;
		}
		
		return result;
	}

}
