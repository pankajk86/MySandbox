package uber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TODO This is unimplemented
public class PrefixAndSuffixSearch {

	public static void main(String[] args) {
		
	}

}

class WordFilter {
	
	private Map<String, Map<String, List<Integer>>> map = new HashMap<>();
	
	public WordFilter(String[] words) {
        for(int i = 0; i < words.length; i++) {
        	String word = words[i];
        	int weight = i;
        	
        	for(int j = 0; j < word.length(); j++) {
        		
        	}
        }
    }
    
    public int f(String prefix, String suffix) {
        return 0;
    }
}
