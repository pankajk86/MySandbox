package facebook;

import java.util.HashMap;
import java.util.Map;

public class ConsecutiveStrings {

	public static void main(String[] args) {
        String input = "Hi how are you. PayPal money works transfer good thank you";
        String query = "money transfer works";
        
        boolean result = matched(input, query);
        System.out.println(result);
    }
    
    private static boolean matched(String input, String query) {
        if(input == null || input.isEmpty() || query == null || query.isEmpty()) return false;
        
        Map<String, Integer> map = new HashMap<>();
        String[] parts = query.split(" ");
        for(String part: parts) map.put(part, map.getOrDefault(part, 0) + 1);
        
        String[] ips = input.split(" ");
        for(int i = 0; i < ips.length; i++) {
        	Map<String, Integer> backup = new HashMap<>(map);
        	boolean isFound = found(map, ips, i);
        	if(isFound) return true;
        	else map = backup;
        }
        return false;
    }
    
    private static boolean found(Map<String, Integer> map, String[] a, int index) {
        for(int i = index; !map.isEmpty(); i++) {    // PayPal money transfer good works thank you
            if(map.containsKey(a[i])) {             // money transfer works
                map.put(a[i], map.get(a[i]) - 1);
                if(map.get(a[i]) == 0) map.remove(a[i]);
                if(map.isEmpty()) return true;
            } else return false;
        }
        return false;
    }

}
