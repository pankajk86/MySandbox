package airbnb;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII_Better {

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
		System.out.println(result);
	}

	private static List<String> findWords(char[][] board, String[] words) {
		List<String> result = new ArrayList<>();
		
		TrieNode root = buildTrie(words);
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				dfs(board, i, j, root, result);
			}
		}
		return result;
	}

	private static void dfs(char[][] board, int i, int j, TrieNode node, List<String> result) {
		char c = board[i][j];
		
		if(c == '#' || node.next[c - 'a'] == null) return;
		node = node.next[c - 'a'];
		
		if(node.word != null) { // found
			result.add(node.word);
			node.word = null; // avoid de-duplication
		}
		
		board[i][j] = '#';
		
		if(i > 0) dfs(board, i - 1, j, node, result);
		if(j > 0) dfs(board, i, j - 1, node, result);
		if(i < board.length - 1) dfs(board, i + 1, j, node, result);
		if(j < board[0].length - 1) dfs(board, i, j + 1, node, result);
		
		board[i][j] = c;
	}

	private static TrieNode buildTrie(String[] words) {

		TrieNode root = new TrieNode();
		for(String word: words) {
			TrieNode curr = root;
			for(char c: word.toCharArray()) {
				int i = c - 'a';
				if(curr.next[i] == null)
					curr.next[i] = new TrieNode();
				curr = curr.next[i];
			}
			curr.word = word;
		}
		return root;
	}

}

class TrieNode {
	TrieNode[] next = new TrieNode[26];
	String word;
}
