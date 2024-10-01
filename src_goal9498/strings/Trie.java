package strings;

public class Trie {

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts given string in the Trie.
     * 
     * @param s
     *            String to be inserted.
     */
    public void insert(String s) {
        TrieNode current = root;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (current.children.containsKey(c)) {
                current = current.children.get(c);
            } else {
                TrieNode newNode = new TrieNode();
                current.children.put(c, newNode);
                current = newNode;
            }
        }
        current.isEndOfWord = true;
    }

    /**
     * Searches the string provided as parameter in the Trie.
     * 
     * @param s
     *            String to be searched.
     * @return true: if found; false: otherwise.
     */
    public boolean search(String s) {

        TrieNode current = root;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (current != null && current.children.containsKey(c)) {
                current = current.children.get(c);
            } else return false;
        }

        return current.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) {
    	
    	TrieNode current = root;
    	
    	for(char c: prefix.toCharArray()) {
    		if(current.children.containsKey(c)) {
    			current = current.children.get(c);
    		} else {
    			return false;
    		}
    	}
    	
    	return true;
    }

    public TrieNode getRoot() {
		return this.root;
	}
}
