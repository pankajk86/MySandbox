package strings;

public class TrieTest {

    public static void main(String[] args) {
//        test1(new Trie());
    	test2(new Trie());
    }
    
    private static void test2(Trie trie) {
    	trie.insert("hello");
    	
    	System.out.println(trie.search("helloa"));
	}

	private static void test1(Trie trie) {
    	trie.insert("abc");
        trie.insert("abgl");
        trie.insert("cdf");
        trie.insert("abcd");
        trie.insert("lmn");

        System.out.println("Trie contains lmn: " + trie.search("lmn"));
        System.out.println("Trie contains ab: " + trie.search("ab"));
        System.out.println("Trie contains cdf: " + trie.search("cdf"));
        System.out.println("Trie contains ghi: " + trie.search("ghi"));
    }

}
