package strings;

import java.util.HashMap;
import java.util.Map;

public class ReplaceStrings {

	public static void main(String[] args) {
		String[] dict = {"cat", "cate", "rat", "sna", "pat", "bat", "obn", "sil", "te", "res"};
		String sentence = "The categories of cattles were rattled by the batteries";
		
		sentence = "The obnoxious categories of silly cattles were rattled by the batteries and terribly rescued snakes";
		long start = System.currentTimeMillis();
		String result = replaceWords(dict, sentence);
		System.out.println("Time Taken: " + (System.currentTimeMillis() - start));
		System.out.println(result);
	}

	private static String replaceWords(String[] dict, String sentence) {
		
		TrieNode root = createTrie(dict);
		StringBuilder sb = new StringBuilder();
		
		for(String word: sentence.split(" ")) {
			String wordRoot = findRoot(root, word);
			if(!wordRoot.isEmpty()) {
				word = word.replace(word.substring(wordRoot.length()), "");
			}
			sb.append(word).append(" ");
		}
		
		return sb.substring(0, sb.length() - 1);
	}
	
	private static String findRoot(TrieNode root, String word) {
		
		TrieNode current = root;
		StringBuilder sb = new StringBuilder();
		int i = 0;
		
		while(current.children.containsKey(word.charAt(i))) {
			sb.append(word.charAt(i));
			current = current.children.get(word.charAt(i));
			i++;
		}

		return current.isEndOfWord ? sb.toString() : "";
	}

	private static TrieNode createTrie(String[] dict) {

		TrieNode root = new TrieNode();
		
		for(String word: dict) {
			TrieNode current = root;
			
			for(int i = 0; i < word.length();) {
				while(current.children.containsKey(word.charAt(i))) {
					current = current.children.get(word.charAt(i));
					i++;
				}
				TrieNode node = new TrieNode();
				current.children.put(word.charAt(i), node);
				
				current = current.children.get(word.charAt(i));
				i++;
			}
			current.isEndOfWord = true;
		}
		
		
		return root;
	}

}

class TrieNode {
	Map<Character, TrieNode> children;
	boolean isEndOfWord;
	
	TrieNode() {
		children = new HashMap<>();
		isEndOfWord = false;
	}
}
