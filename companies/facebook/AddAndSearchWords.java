package facebook;

public class AddAndSearchWords {

	public static void main(String[] args) {
		WordDictionary wd = new WordDictionary();
		wd.addWord("bad");
		wd.addWord("dad");
		wd.addWord("mad");
		System.out.println(wd.searchWord("pad"));
		System.out.println(wd.searchWord("bad"));
		System.out.println(wd.searchWord(".ad"));
		System.out.println(wd.searchWord("b.."));
	}

}

class WordDictionary {
	
	TrieNode root = null;
	
	public WordDictionary() {
		root = new TrieNode();
	}
	
	public void addWord(String word) {
		TrieNode curr = root;
		
		for(char c: word.toCharArray()) {
			if(curr.children[c - 'a'] == null)
				curr.children[c - 'a'] = new TrieNode();
			curr = curr.children[c - 'a'];
		}
		curr.word = word;
	}
	
	public boolean searchWord(String word) {
		return match(root, 0, word.toCharArray());
	}

	private boolean match(TrieNode node, int k, char[] carr) {

		if(k == carr.length) 
			return !node.word.equals("");
		
		if(carr[k] != '.') 
			return node.children[carr[k] - 'a'] != null && match(node.children[carr[k] - 'a'], k + 1, carr);
		else {
			for(int i = 0; i < node.children.length; i++) {
				if(node.children[i] != null && match(node.children[i], k + 1, carr))
					return true;
			}
		}
		return false;
	}
}

class TrieNode {
	TrieNode[] children = new TrieNode[26];
	String word = "";
}
