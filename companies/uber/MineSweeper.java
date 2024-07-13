package uber;

public class MineSweeper {

	static int[][] dirs = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}, {0, -1}, {-1, 0}, {0, 1}, {1, 0}};

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
		int r = click[0], c = click[1], m = board.length, n = board[0].length;

		if (board[r][c] == 'M' || board[r][c] == 'X') {
			board[r][c] = 'X';
			return board;
		}

		int mines = 0;
		for (int[] dir : dirs) {
			int nr = r + dir[0], nc = c + dir[1];
			if (nr >= 0 && nr < m && nc >= 0 && nc < m && board[nr][nc] == 'M') {
				mines++;
			}
		}

		if (mines > 0) {
			board[r][c] = (char)(mines + '0');
			return board;
		}

		board[r][c] = 'B';

		for (int[] dir : dirs) {
			int nr = r + dir[0], nc = c + dir[1];
			if (nr >= 0 && nr < m && nc >= 0 && nc < m && board[nr][nc] == 'E') {
				updateBoard(board, new int[]{nr, nc});
			}
		}

		return board;
	}

}
