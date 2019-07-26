package google;

import java.util.HashMap;
import java.util.Map;

public class StreamOfCharacters {

	public static void main(String[] args) {
		String[] words = { "ab", "ba", "aaab", "abab", "baa" };
		StreamChecker streamChecker = new StreamChecker(words);
		
		System.out.println(streamChecker.query('a'));
		System.out.println(streamChecker.query('a'));
		System.out.println(streamChecker.query('a'));
		System.out.println(streamChecker.query('a'));
		System.out.println(streamChecker.query('a'));
		System.out.println(streamChecker.query('b'));
		System.out.println(streamChecker.query('a'));
		System.out.println(streamChecker.query('b'));
		System.out.println(streamChecker.query('a'));
		System.out.println(streamChecker.query('b'));
		System.out.println(streamChecker.query('b'));
		System.out.println(streamChecker.query('b'));
		System.out.println(streamChecker.query('a'));
		System.out.println(streamChecker.query('b')); //
		System.out.println(streamChecker.query('a'));
		System.out.println(streamChecker.query('b'));
		System.out.println(streamChecker.query('b'));
		System.out.println(streamChecker.query('b'));
		System.out.println(streamChecker.query('b'));
		System.out.println(streamChecker.query('a'));
		System.out.println(streamChecker.query('b'));
		System.out.println(streamChecker.query('a'));
		System.out.println(streamChecker.query('b'));
		System.out.println(streamChecker.query('a'));
		System.out.println(streamChecker.query('a'));
		System.out.println(streamChecker.query('a'));
		System.out.println(streamChecker.query('b'));
		System.out.println(streamChecker.query('a'));
		System.out.println(streamChecker.query('a'));
		System.out.println(streamChecker.query('a'));
	}

}


class StreamChecker {
	
	private TrieNode root = null;
	private StringBuilder sb = new StringBuilder();
	
	public StreamChecker(String[] words) {
		root = createTrie(words);
	}

	private TrieNode createTrie(String[] words) {
		TrieNode root = new TrieNode();
		
		for(String word: words) {
			TrieNode curr = root;
			for(int i = word.length() - 1; i >= 0; i--) {
				char c = word.charAt(i);
				if(!curr.children.containsKey(c))
					curr.children.put(c, new TrieNode());

				curr = curr.children.get(c);
			}
			curr.isEndOfWord = true;
		}
		return root;
	}

	public boolean query(char letter) {
		sb.append(letter);
		
		TrieNode curr = root;
		for(int i = sb.length() - 1; i >= 0 && curr.children.containsKey(sb.charAt(i)); i--) {
			curr = curr.children.get(sb.charAt(i));
			if(curr != null && curr.isEndOfWord)
				return true;
		}
		
		return false;
	}
}

class TrieNode {
	Map<Character, TrieNode> children;
	boolean isEndOfWord;
	
	TrieNode() {
		this.children = new HashMap<>();
	}
}