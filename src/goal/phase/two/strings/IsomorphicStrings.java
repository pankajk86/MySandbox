package goal.phase.two.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Has Bug. Current test case shows that.
 */
public class IsomorphicStrings {

    public static void main(String[] args) {

        String a = "paper", b = "title";
        boolean result = isIsomorphic(a, b);

        System.out.println("Result: " + result);
    }

    private static boolean isIsomorphic(String s1, String s2) {

        Map<Character, Character> map = new HashMap<Character, Character>();

        if (s1.length() != s2.length()) {
            return false;
        }

        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();

        for (int i = 0; i < a.length; i++) {
            if (!map.containsKey(a[i])) {
            	if(!map.containsValue(b[i])) map.put(a[i], b[i]);
            	else return false;
            } else {
                if (b[i] != map.get(a[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
