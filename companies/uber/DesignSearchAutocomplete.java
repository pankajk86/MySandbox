package uber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DesignSearchAutocomplete {

	public static void main(String[] args) {
		test1();
		test2();
	}
	
	private static void test1() {
		String[] sentences = { "i love you", "island", "ironman", "i love leetcode" };
		int[] times = { 5, 3, 2, 2 };
		
		AutocompleteSystem as = new AutocompleteSystem(sentences, times);
		List<List<String>> result = new ArrayList<>();
		
		List<String> l1 = as.input('i');
		List<String> l2 = as.input(' ');
		List<String> l3 = as.input('a');
		List<String> l4 = as.input('#');
		result.addAll(Arrays.asList(l1, l2, l3, l4));
		
		System.out.println(result);
	}
	
	private static void test2() {
		String[] sentences = { "abc", "abbc", "a" };
		int[] times = { 3, 3, 3 };
		
		AutocompleteSystem as = new AutocompleteSystem(sentences, times);
		List<List<String>> result = new ArrayList<>();
		
		result.add(as.input('b'));
		result.add(as.input('c'));
		result.add(as.input('#'));
		
		result.add(as.input('b'));
		result.add(as.input('c'));
		result.add(as.input('#'));
		
		result.add(as.input('a'));
		result.add(as.input('b'));
		result.add(as.input('c'));
		result.add(as.input('#'));
		
		result.add(as.input('a'));
		result.add(as.input('b'));
		result.add(as.input('c'));
		result.add(as.input('#'));
		
		System.out.println(result);
	}
}

class AutocompleteSystem {
	
	private TrieNode root = null;
	private StringBuilder sb = null;
	private Map<String, Integer> map = null;
	
	public AutocompleteSystem(String[] sentences, int[] times) {
		root = createTrie(sentences);
		sb = new StringBuilder();
		map = new HashMap<>();
		
		for(int i = 0; i < sentences.length; i++)
			map.put(sentences[i], times[i]);
	}
	
	public List<String> input(char c) {
		String prefix = null;
		
		if(c != '#') {
			sb.append(c);
			prefix = sb.toString();
			
			List<String> list = startsWith(prefix);
			Collections.sort(list, new Comparator<String>() {
				@Override
				public int compare(String s1, String s2) {
					if(map.get(s1) > map.get(s2)) return -1;
					else if(map.get(s1) < map.get(s2)) return 1;
					else return s1.compareTo(s2);
				}
			});
			
			if(list.size() <= 3) return list;
			else return new ArrayList<>(list.subList(0, 3));
			
		} else {
			prefix = sb.toString();
			sb = new StringBuilder();
			
			if(!map.containsKey(prefix))
				addSentence(root, prefix);
			map.put(prefix, map.getOrDefault(prefix, 0) + 1);
			return new ArrayList<>();
		}
	}
	
	private List<String> startsWith(String prefix) {
		TrieNode curr = root;
		int i = 0;
		
		while(i < prefix.length() && curr.children.containsKey(prefix.charAt(i))) {
			char c = prefix.charAt(i);
			if(i + 1 == prefix.length())
				return curr.startsWith.get(c);
			curr = curr.children.get(c);
			i++;
		}
		return new ArrayList<>();
	}
	
	private TrieNode createTrie(String[] sentences) {
		TrieNode root = new TrieNode();
		
		for(String s: sentences) {
			addSentence(root, s);
		}
		return root;
	}
	
	private void addSentence(TrieNode root, String s) {
		TrieNode curr = root;
		
		for(int i = 0; i < s.length(); ) {
			while(i < s.length() && curr.children.containsKey(s.charAt(i))) {
				List<String> prefix = curr.startsWith.getOrDefault(s.charAt(i), new ArrayList<>());
				prefix.add(s);
				curr = curr.children.get(s.charAt(i));
				i++;
			}
			
			if(i < s.length()) {
				TrieNode newNode = new TrieNode();
				curr.children.put(s.charAt(i), newNode);
				List<String> list = new ArrayList<>();
				list.add(s);
				curr.startsWith.put(s.charAt(i), list);
				curr = newNode;
				i++;
			}
		}
		curr.isEndOfWord = true;
	}
}


class TrieNode {
	Map<Character, TrieNode> children;
	Map<Character, List<String>> startsWith;
	boolean isEndOfWord;
	
	TrieNode() {
		children = new HashMap<>();
		startsWith = new HashMap<>();
	}
}
