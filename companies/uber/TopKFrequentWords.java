package uber;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TopKFrequentWords {

	public static void main(String[] args) {
		String[] words = {"i", "love", "leetcode", "i", "love", "coding"}; //{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
		int k = 3;
		
		List<String> result = topKFrequent(words, k);
		for(String s: result)
			System.out.print(s + ", ");
	}
	
	private static List<String> topKFrequent(String[] words, int k) {
		
		Map<String, Integer> map = new HashMap<>();
		List<String> result = new ArrayList<>();
		
		for(String s: words) {
			if(!map.containsKey(s)) 
				map.put(s, 1);
			else
				map.put(s, map.get(s) + 1);
		}
		
		TreeMap<String, Integer> treeMap = new TreeMap<>(new WordComparator(map));
		treeMap.putAll(map);
		
		Set<String> set = treeMap.keySet();
		Iterator<String> it = set.iterator();
		int i = 0;
		
		while(it.hasNext() && i < k) {
			result.add(it.next());
			i++;
		}
		
		return result;
	}

}

class WordComparator implements Comparator<String> {
	
	Map<String, Integer> map;
	
	WordComparator(Map<String, Integer> map) {
		this.map = map;
	}

	@Override
	public int compare(String s1, String s2) {

		if(map.get(s1) > map.get(s2))
			return -1;
		else if (map.get(s1) == map.get(s2)) {
			if(s1.compareTo(s2) < 0)
				return -1;
			else
				return 1;
		}
		
		return 1;
	}
}
