package strings;

public class LongestCommonPrefix {

    public static void main(String[] args) {

        String[] a = { "abcd efg", "abc defg", "abcd efghi", "abcdefg" };
        String prefix = getLongestCommonPrefix(a);

        System.out.println("Result: " + prefix);
        
        testTrie();
        testTrie2();
    }

    private static String getLongestCommonPrefix(String[] str) {

        String shortest = null;
        int shortestCount = Integer.MAX_VALUE;

        for (String s : str) {
            if (s.length() < shortestCount) {
                shortestCount = s.length();
                shortest = s;
            }
        }

        for (int i = 0; i < shortestCount; i++) {
            for (int j = 0; j < str.length - 1; j++) {
                String s1 = str[j];
                String s2 = str[j + 1];

                if (s1.charAt(i) != s2.charAt(i)) {
                    return s1.substring(0, i);
                }
            }
        }

        return shortest;
    }

    private static void testTrie() {
    	String[] a = { "flower", "flow", "flight" }; // { "a", "ac" }; // {"bb","b"}; // 
    	
    	Trie trie = new Trie();
    	for(String s: a)
    		trie.insert(s);
    	TrieNode root = trie.getRoot();
    	
    	StringBuilder sb = new StringBuilder();
    	
    	while(root.children.size() == 1) {
    		char c = (char) root.children.keySet().toArray()[0];
    		sb.append(c);
    		
    		root = root.children.get(c);
    		if(root.isEndOfWord) {
    			break;
    		}
    	}
    	
    	System.out.println("LongestCommonPrefix: " + sb.toString());
    	System.out.println(trie.startsWith("flt"));
    }
    
    private static void testTrie2() {
    	Trie trie = new Trie();
    	trie.insert("hello");
    	boolean result1 = trie.search("hell");
    	boolean result2 = trie.search("helloa");
    	boolean result5 = trie.search("hello");
    	boolean result3 = trie.startsWith("hell");
    	boolean result6 = trie.startsWith("helloa");
    	boolean result7 = trie.startsWith("hello");
    	System.out.println(result1 + ", " + result2 + ", " + result3 );
    }
}
