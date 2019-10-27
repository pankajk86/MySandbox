package airbnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePairs {

	public static void main(String[] args) {
		String[] words = { "abcd", "dcba", "lls", "s", "sssll" };
		List<List<Integer>> result = palindromePairsWithTrie(words);
		System.out.println(result);
	}
	
	private static List<List<Integer>> palindromePairsWithTrie(String[] words) {
		List<List<Integer>> result = new ArrayList<>();
		if(words == null || words.length == 0) return result;
		
		TrieNodePP root = new TrieNodePP();
		for(int i = 0; i < words.length; i++)
			addWord(root, words[i], i);
		
		for(int i = 0; i < words.length; i++)
			search(words, i, root, result);
		
		return result;
	}
	
	private static void addWord(TrieNodePP root, String word, int index) {
		for(int i = word.length() - 1; i >= 0; i--) {
			char c = word.charAt(i);
			
			if(!root.children.containsKey(c))
				root.children.put(c, new TrieNodePP());
			
			if(isPalindrome(word, 0, i))
				root.list.add(index);
			
			root = root.children.get(c);
		}
		
		root.list.add(index);
		root.index = index;
	}

	private static void search(String[] words, int i, TrieNodePP root, List<List<Integer>> result) {
		for(int j = 0; j < words[i].length(); j++) {
			if(root.index >= 0 && root.index != i && isPalindrome(words[i], j, words[i].length() - 1))
				result.add(Arrays.asList(i, root.index));
			
			root = root.children.get(words[i].charAt(j));
			if(root == null) return;
		}
		
		for(int j: root.list) {
			if(i == j) continue;
			result.add(Arrays.asList(i, j));
		}
	}

	private static boolean isPalindrome(String word, int start, int end) {
		while(start <= end) {
			if(word.charAt(start) == word.charAt(end)) {
				start++; end--;
			} else return false;
		}
		return true;
	}
}

class TrieNodePP {
	Map<Character, TrieNodePP> children;
	int index;
	List<Integer> list;

    public TrieNodePP() {
        children = new HashMap<>();
        index = -1;
        list = new ArrayList<>();
    }
    
    @Override
    public String toString() {
    	return children.keySet().toString();
    }
}
