package strings;

public class TrieTest {

    public static void main(String[] args) {
        Trie trie = new Trie();
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
