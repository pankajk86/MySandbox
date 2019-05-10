package uber;

public class MineSweeper {

	public static void main(String[] args) {
		char[][] board = {
				{'E', 'E', 'E', 'E', 'E'},
				{'E', 'E', 'M', 'E', 'E'},
				{'E', 'E', 'E', 'E', 'E'},
				{'E', 'E', 'E', 'E', 'E'}};
		
		int[] click = {3, 0};
		
		char[][] result = updateBoard(board, click);
		
		for(int i = 0; i < result.length; i++) {
			for(int j = 0; j < result[0].length; j++)
				System.out.print(result[i][j] + " ");
			System.out.println();
		}
	}

	private static char[][] updateBoard(char[][] board, int[] click) {
		int row = click[0], col = click[1];
		
		if(row >= 0 && row < board.length && col >= 0 && col < board[0].length) {
			if(board[row][col] == 'M') {
				board[row][col] = 'X';
				return board;
			}
			
			if(board[row][col] == 'E') {
				int countMines = 0;
				if(row - 1 >= 0 && col - 1 >= 0 && board[row - 1][col - 1] == 'M') countMines++;
				if(row - 1 >= 0 && col >= 0 && board[row - 1][col] == 'M') countMines++;
				if(row - 1 >= 0 && col + 1 < board[0].length && board[row - 1][col + 1] == 'M') countMines++;
				if(row >= 0 && col + 1 < board[0].length && board[row][col + 1] == 'M') countMines++;
				if(row + 1 < board.length && col + 1 < board[0].length && board[row + 1][col + 1] == 'M') countMines++;
				if(row + 1 < board.length && col < board[0].length && board[row + 1][col] == 'M') countMines++;
				if(row + 1 < board.length && col - 1 >= 0 && board[row + 1][col - 1] == 'M') countMines++;
				if(row >= 0 && col - 1 >= 0 && board[row][col - 1] == 'M') countMines++;
				
				if(countMines > 0) {
					board[row][col] = (char) (countMines + '0');
					return board;
				} else {
					board[row][col] = 'B';
					board = updateBoard(board, new int[] {row - 1, col - 1});
					board = updateBoard(board, new int[] {row - 1, col});
					board = updateBoard(board, new int[] {row - 1, col + 1});
					board = updateBoard(board, new int[] {row, col + 1});
					board = updateBoard(board, new int[] {row + 1, col + 1});
					board = updateBoard(board, new int[] {row + 1, col});
					board = updateBoard(board, new int[] {row + 1, col - 1});
					board = updateBoard(board, new int[] {row, col - 1});
					return board;
				}
			}
		}
		return board;
	}

}
