package uber;

import java.util.ArrayList;
import java.util.List;

// NOT COMPLETE YET
public class TextJustification {

	public static void main(String[] args) {
//		String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		String[] words = {"Tushar", "Roy", "likes", "to", "code"};
		int maxWidth = 10;
		
		List<String> result = fullyJustify(words, maxWidth);
		System.out.println(result);
	}

	private static List<String> fullyJustify(String[] words, int maxWidth) {
		List<String> result = new ArrayList<>();
		int size = words.length;
		
		int[][] dp = squareCostMatrix(words, maxWidth);
		
		int[] minCost = new int[size];
		int[] index = new int[size];
		
		for(int i = size - 1; i >= 0; i--) {
			minCost[i] = dp[i][size - 1];
			index[i] = size;
			
			for(int j = size - 1; j > i; j--) {
				if(dp[i][j - 1] == Integer.MAX_VALUE) {
					continue;
				}
				int cost = minCost[j] + dp[i][j - 1];
				if(cost < minCost[i]) {
					minCost[i] = cost;
					index[i] = j;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(words[0]);
		
		for(int i = 1; i < size; i++) {
			if(index[i] != index[i - 1]) {
				result.add(sb.toString());
				sb = new StringBuilder();
			}
			sb.append(words[i]).append(" ");
		}
		result.add(sb.toString());
		return result;
	}
	
	private static int[][] squareCostMatrix(String[] words, int maxWidth) {
		int size = words.length;
		
		int[] len = new int[size];
		int[][] result = new int[size][size];
		
		for(int i = 0; i < size; i++) {
			if(i == 0) len[i] = words[i].length();
			else len[i] = len[i - 1] + 1 + words[i].length();
		}
		
		for(int i = 0; i < size; i++) {
			for(int j = i; j < size; j++) {
				int occupied = len[j];
				if(i != 0)
					occupied -= len[i - 1] + 1;
				int empty = maxWidth - occupied;
				result[i][j] = empty >= 0 ? (int) Math.pow(empty, 2) : Integer.MAX_VALUE;
			}
		}
		
		return result;
	}

}
