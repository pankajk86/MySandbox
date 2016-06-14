package goal.phase.two.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * NOT COMPLETE YET
 */
public class MinimumWindowSubstring {

    public static void main(String[] args) {

        String s = "XDADOBECODEBANC";
        String t = "ABC";

        String minWindow = getMinWindowSubstring(s, t);
    }

    private static String getMinWindowSubstring(String s, String t) {

        String temp = "", min = s;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            if (!t.contains(String.valueOf(s.charAt(i)))) {
                start++;
            } else {
                break;
            }
        }

        for (int i = start; i < s.length(); i++) {

            char c = s.charAt(i);

            if (t.contains(String.valueOf(c))) { // {A=2, B=5, C=7}
                map.put(c, i);
            }

            temp += c;

            if (map.size() == t.length() && min.length() > temp.length()) {
                min = temp;
                break;
            }
        }

        int size = min.length();

        for (int i = start + 1; i < s.length(); i++) { // XDA-DOBECODEBANC
            if (exists(s, t, i, size)) {

            }
        }

        return min;
    }

    private static boolean exists(String s, String t, int start, int size) {

        int count = 0;

        for (int i = start; i <= start + size; i++) {
            if (t.contains(String.valueOf(s.charAt(i)))) { // DOBECO
                count++;
            }
        }

        if (count == t.length()) {
            return true;
        }

        return false;
    }

}
