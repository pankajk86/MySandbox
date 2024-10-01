package uber;

public class WordSearch {

	private static int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
	
	public static void main(String[] args) {
		char[][] board = {
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}
		};
		
		String word = "ABCCED";
		boolean result = exist(board, word);
		System.out.println(result);
		
		String t = "6";
		System.out.println(Integer.parseInt(t) + 1);
	}

	/**
	 * T : O(M . N . 4^L) = M, N - dimension of the board, L = length of the word.
	 * S : O(M . N)
	 *
	 * @param board
	 * @param word
	 * @return
	 */
	private static boolean exist(char[][] board, String word) {

		boolean[][] visited = new boolean[board.length][board[0].length];
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(word.charAt(0) == board[i][j] && search(board, word, i, j, 0, visited))
					return true;
			}
		}
		return false;
	}

	private static boolean search(char[][] board, String word, int i, int j, int index, boolean[][] visited) {

		if(index == word.length()) return true;
		
		if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || 
				word.charAt(index) != board[i][j] || visited[i][j])
			return false;
		
		visited[i][j] = true;
		boolean result = false;
		
		for(int[] dir: dirs) {
            int x = i + dir[0], y = j + dir[1];
            result |= search(board, word, x, y, index + 1, visited);
        }
		
		if(result) return true;
		visited[i][j] = false;
		return false;
	}

}
