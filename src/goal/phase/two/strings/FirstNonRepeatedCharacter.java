package goal.phase.two.strings;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatedCharacter {

    public static void main(String[] args) {
        String s = "Salesforce is the best company to work for";
        s = s.toLowerCase();

        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) == 1) {
                System.out.println(c);
                break;
            }
        }
    }

}
