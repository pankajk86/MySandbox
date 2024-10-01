package uber;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {

	public static void main(String[] args) {
		char[][] board = {
				  {'5','3','.','.','7','.','.','.','.'},
				  {'6','.','.','1','9','5','.','.','.'},
				  {'.','9','8','.','.','.','.','6','.'},
				  {'8','.','.','.','6','.','.','.','3'},
				  {'4','.','.','8','.','3','.','.','1'},
				  {'7','.','.','.','2','.','.','.','6'},
				  {'.','6','.','.','.','.','2','8','.'},
				  {'.','.','.','4','1','9','.','.','5'},
				  {'.','.','.','.','8','.','.','7','9'}
				};
		boolean result = isValidSudoku(board);
		System.out.println(result);
	}

	private static boolean isValidSudoku(char[][] board) {
		Map<Integer, Set<Character>> rows = new HashMap<>();
		Map<Integer, Set<Character>> cols = new HashMap<>();
		Map<Integer, Set<Character>> subs = new HashMap<>();

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				char c = board[i][j];
				if (board[i][j] == '.') continue;

				Set<Character> row = rows.getOrDefault(i, new HashSet<>());
				Set<Character> col = cols.getOrDefault(j, new HashSet<>());
				Set<Character> sub = subs.getOrDefault((i / 3) * 3 + (j / 3), new HashSet<>());

				if (row.contains(c) || col.contains(c) || sub.contains(c)) return false;

				row.add(c); col.add(c); sub.add(c);
				rows.put(i, row);
				cols.put(j, col);
				subs.put((i / 3) * 3 + (j / 3), sub);
			}
		}
		return true;
	}

}
