package uber;

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

		int[] rows = new int[9];
		int[] cols = new int[9];
		int[] squares = new int[9];
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(board[i][j] == '.') {
					continue;
				}
				
				int value = 1 << (board[i][j] - '0');
				
				if((value & rows[i]) > 0) return false;
				if((value & cols[j]) > 0) return false;
				if((value & squares[3 * (i/3) + (j/3)]) > 0) return false;
				
				rows[i] |= value;
				cols[j] |= value;
				squares[3 * (i/3) + (j/3)] |= value;
			}
		}
		
		return true;
	}

}
