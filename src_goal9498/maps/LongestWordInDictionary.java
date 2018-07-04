package maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LongestWordInDictionary {

	public static void main(String[] args) {
		String[] dict = { "vsw", "vs", "zwu", "vsx", "nc", "o", "vswus", "orv", "imf", "i", "v", "zw", "vs" };
		String result = longestWord(dict);
		System.out.println(result);

	}

	private static String longestWord(String[] dict) {

		Trie trie = new Trie();
		int index = 0;

		for (String word : dict) {
			trie.insert(word, ++index);
		}

		trie.words = dict;
		return trie.dfs();
	}

}

class Trie {
	Node root;
	String[] words;

	public Trie() {
		root = new Node('0');
	}

	public void insert(String word, int index) {
		Node curr = root;

		for (char c : word.toCharArray()) {
			curr.children.putIfAbsent(c, new Node(c));
			curr = curr.children.get(c);
		}
		curr.end = index;
	}

	public String dfs() {
		String ans = "";
		Stack<Node> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			Node node = stack.pop();

			if (node.end > 0 || node == root) {
				if (node != root) {
					String word = words[node.end - 1];
					if(word.length() > ans.length() ||
							word.length() == ans.length() && word.compareTo(ans) < 0) {
						ans = word;
					}
				}
				for(Node n: node.children.values()) {
					stack.push(n);
				}
			}
		}
		return ans;
	}
}

class Node {
	char c;
	int end;
	Map<Character, Node> children = new HashMap<>();

	public Node(char c) {
		this.c = c;
	}
}
