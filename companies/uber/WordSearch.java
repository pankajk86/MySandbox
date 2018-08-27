package uber;

public class WordSearch {

	private static boolean[][] isVisited;
	
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

	private static boolean exist(char[][] board, String word) {

		isVisited = new boolean[board.length][board[0].length];
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(word.charAt(0) == board[i][j] && search(board, word, i, j, 0))
					return true;
			}
		}
		return false;
	}

	private static boolean search(char[][] board, String word, int i, int j, int index) {

		if(index == word.length()) return true;
		
		if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || 
				word.charAt(index) != board[i][j] || isVisited[i][j])
			return false;
		
		isVisited[i][j] = true;
		
		if(search(board, word, i + 1, j, index + 1) 
			|| search(board, word, i - 1, j, index + 1)
			|| search(board, word, i, j + 1, index + 1)
			|| search(board, word, i, j - 1, index + 1))
			return true;
		
		isVisited[i][j] = false;
		return false;
	}

}
