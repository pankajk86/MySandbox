package goal.phase.two.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithTwoUniqueCharacters {

    public static void main(String[] args) {

        String s = "abcbbbbcccbdddadacb";
        String sub = getLongest(s);
        System.out.println(sub);
    }

    private static String getLongest(String s) {

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int temp = 0, count = Integer.MIN_VALUE, start = 0;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }

            if (map.size() > 2) {

                if (i - temp > count) {
                    count = i - temp;
                    start = temp;
                }

                while (map.size() > 2) {
                    char t = s.charAt(temp);
                    int num = map.get(t);
                    if (num > 1) {
                        map.put(t, num - 1);
                    } else {
                        map.remove(t);
                    }
                    temp++;
                }
            }
        }

        return s.substring(start, start + count);
    }
}
