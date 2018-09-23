package airbnb;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SlidingPuzzle {

	public static void main(String[] args) {
		int[][] board = { { 4, 1, 2 }, { 5, 0, 3 } };
		int result = minMoves(board);
		System.out.println(result);
	}

	private static int minMoves(int[][] board) {

		String start = "", target = "123450";
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++)
				start += board[i][j];
		}
		
		int[][] dirs = {
						{1, 3}, {0, 2, 4}, {1, 5},
						{0, 4}, {1, 3, 5}, {2, 4}
					};
		
		Set<String> visited = new HashSet<>();
		Queue<String> q = new LinkedList<>();
		visited.add(start); q.add(start);
		int result = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0; i < size; i++) {
				String curr = q.poll();
				
				if(curr.equals(target))
					return result;
				
				int index = curr.indexOf('0');
				
				for(int dir: dirs[index]) {
					String next = swap(curr, index, dir);
					if(!visited.contains(next)) {
						visited.add(next);
						q.add(next);
					}
				}
			}
			result++;
		}
		return -1;
	}

	private static String swap(String curr, int i, int j) {

		StringBuilder sb = new StringBuilder(curr);
		char temp = sb.charAt(i);
		sb.setCharAt(i, sb.charAt(j));
		sb.setCharAt(j, temp);
		return sb.toString();
	}

}
