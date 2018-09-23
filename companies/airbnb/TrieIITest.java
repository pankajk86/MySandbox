package airbnb;

public class TrieIITest {

	public static void main(String[] args) {
		TrieII trie = new TrieII();
		String[] words = { "oath", "pea", "eat", "rain" };
		
		trie.buildTrie(words);
		System.out.println("oath? " + trie.search("oath"));
		System.out.println("othello? " + trie.search("othello"));
	}

}
