package strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {
	
	public static void main(String[] args) {

		String[] words = { "oath", "pea", "eat", "rain" };
		char[][] board = {
				  {'o','a','a','n'},
				  {'e','t','a','e'},
				  {'i','h','k','r'},
				  {'i','f','l','v'}
				};

		long start = System.currentTimeMillis();
		List<String> result = findWords(board, words);
		System.out.println(System.currentTimeMillis() - start);
		
		for(String word: result)
			System.out.println(word);
	}

	private static List<String> findWords(char[][] board, String[] words) {

		Set<String> result = new HashSet<>();
		Trie trie = new Trie();
		
		for(String word: words)
			trie.insert(word);
		
		int rows = board.length;
		int cols = rows > 0 ? board[0].length : 0;
		boolean[][] visited = new boolean[rows][cols];
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				dfs(board, visited, "", i, j, trie, result);
			}
		}
		
		return new ArrayList<>(result);
	}

	private static void dfs(char[][] board, boolean[][] visited, String str, 
			int i, int j, Trie trie, Set<String> result) {
		
		if(i < 0 || i >= board.length || j < 0 || j >= board[0].length)
			return;
		
		if(visited[i][j])
			return;
		
		str += board[i][j];
		if(!trie.startsWith(str))
			return;
		
		if(trie.search(str))
			result.add(str);
		
		visited[i][j] = true;
		dfs(board, visited, str, i - 1, j, trie, result);
		dfs(board, visited, str, i + 1, j, trie, result);
		dfs(board, visited, str, i, j - 1, trie, result);
		dfs(board, visited, str, i, j + 1, trie, result);
		visited[i][j] = false;
	}

}
