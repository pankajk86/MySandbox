package strings;

public class TrieTest {

    public static void main(String[] args) {
        test1(new Trie());
    	test2(new Trie());
    	test3(new Trie());
    }
    
    private static void test3(Trie trie) {
		trie.insert("ab");
		System.out.println(trie.search("abc"));
		System.out.println(trie.search("ab"));
		System.out.println(trie.startsWith("abc"));
		System.out.println(trie.startsWith("ab"));
		trie.insert("ab");
		System.out.println(trie.search("abc"));
		System.out.println(trie.startsWith("abc"));
		trie.insert("abc");
		System.out.println(trie.search("abc"));
		System.out.println(trie.startsWith("abc"));
		
		//Expected : [false,true,false,true,false,false,true,true]
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
