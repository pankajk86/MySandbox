package goal.phase.two.trees;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    private TrieNode root;

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

            if (current.children.containsKey(c)) {
                current = current.children.get(c);
            }

            if (current == null) {
                return false;
            }
        }

        return current.isEndOfWord;
    }

}

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}

