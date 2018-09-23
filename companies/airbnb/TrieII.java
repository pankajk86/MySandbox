package airbnb;

public class TrieII {

	private TrieNode root; 
	
	public TrieII() {
		this.root = new TrieNode();
	}
	
	public TrieNode buildTrie(String[] words) {
		
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
		return this.root;
	}
	
	public boolean search(String word) {
		
		TrieNode curr = root;
		
		for(char c: word.toCharArray()) {
			int i = c - 'a';
			if(curr.next[i] == null)
				return false;
			curr = curr.next[i];
		}
		return word.equals(curr.word);
	}
}