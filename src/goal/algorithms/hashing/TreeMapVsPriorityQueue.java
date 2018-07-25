package goal.algorithms.hashing;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class TreeMapVsPriorityQueue {

	public static void main(String[] args) {
		String s = "abccbdebbfgkcccadelkfjdlfjeoiueolperpiweddhdhdflfdljkdlkfldldfljdfldkldfjhererocdfdffdfleerssdljddaaabbccldbbddddeeelllllsdff";
		long start = System.currentTimeMillis();
		char result = mostRepeatedUsingTM(s, 2);
		System.out.println("Using TreeMap: " + result + ", time: " + (System.currentTimeMillis() - start));
		
		start = System.currentTimeMillis();
		result = mostRepeaterUsingPQ(s, 2);
		System.out.println("Using PriorityQueue: " + result + ", time: "  + (System.currentTimeMillis() - start));
	}

	private static char mostRepeaterUsingPQ(String s, int k) {

		Map<Character, Integer> map = new HashMap<>();
		PriorityQueue<CharFreq> pq = new PriorityQueue<>(new PQComparator());
		
		for(char c: s.toCharArray())
			map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
		
		for(Map.Entry<Character, Integer> entry: map.entrySet()) {
			CharFreq cf = new CharFreq(entry.getKey(), entry.getValue()); 
			if(pq.size() == k) {
				if(pq.peek().freq < cf.freq) {
					pq.poll();
					pq.add(cf);
				}
			} else
				pq.add(cf);
		}
		
		return pq.peek().c;
	}

	private static char mostRepeatedUsingTM(String s, int freq) {

		Map<Character, Integer> map = new HashMap<>();
		
		for(char c: s.toCharArray())
			map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
		
		TreeMap<Character, Integer> tmap = new TreeMap<>(new MapComparator(map));
		tmap.putAll(map);
		char result = '\0';
		int i = 1;
		
		for(Map.Entry<Character, Integer> entry: tmap.entrySet()) {
			if(i < freq)
				i++;
			else {
				result = entry.getKey();
				break;
			}
		}
			
		return result;
	}

}

class PQComparator implements Comparator<CharFreq> {

	@Override
	public int compare(CharFreq c1, CharFreq c2) {
		if(c1.freq < c2.freq)
			return -1;
		else if(c1.freq > c2.freq)
			return 1;
		return 0;
	}
	
}

class MapComparator implements Comparator<Character> {
	
	Map<Character, Integer> map;
	
	MapComparator(Map<Character, Integer> map) {
		this.map = map;
	}

	@Override
	public int compare(Character c1, Character c2) {

		if(map.get(c1) > map.get(c2))
			return -1;
		else if(map.get(c1) < map.get(c2))
			return 1;
		
		return 0;
	}
	
}


class CharFreq {
	char c; int freq;
	
	CharFreq(char c, int freq) {
		this.c = c; this.freq = freq;
	}
}