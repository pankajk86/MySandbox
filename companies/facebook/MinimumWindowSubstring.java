package facebook;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String[] args) {

        String s = "a";
        String t = "ab";

        String result = getMinWindowSubstring(s, t);
        System.out.println(result);
    }

    private static String getMinWindowSubstring(String s, String t) {
    	if(s == null || s.isEmpty() || t == null || t.isEmpty()) return "";
    	
    	Map<Character, Integer> map = new HashMap<>();
    	for(char c: t.toCharArray())
    		map.put(c, map.getOrDefault(c, 0) + 1);
    	
    	int left = 0, minLeft = 0, minLen = s.length() + 1, count = 0;
    	
    	for(int right = 0; right < s.length(); right++) {
    		char r = s.charAt(right);
    		if(map.containsKey(r)) {
    			map.put(r, map.get(r) - 1);
    			if(map.get(r) >= 0)
    				count++;
    			
    			while(count == t.length()) {
    				if(right - left + 1 < minLen) {
    					minLeft = left;
    					minLen = right - left + 1;
    				}
    				
    				char l = s.charAt(left);
    				if(map.containsKey(l)) {
    					map.put(l, map.get(l) + 1);
    					if(map.get(l) > 0)
    						count--;
    				}
    				left++;
    			}
    		}
    	}
    	return minLeft > s.length() ? "" : s.substring(minLeft, minLeft + minLen);
	}
}
