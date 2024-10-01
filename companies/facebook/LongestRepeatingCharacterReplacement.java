package facebook;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;

        int result = characterReplacement(s, k);
        System.out.println(result);
    }

    private static int characterReplacement(String s, int k) {
        int result = 0;
        int[] map = new int[26];
        int maxFreq = 0;

        for (int i = 0, j = 0; j < s.length(); j++) {
            char cj = s.charAt(j);
            map[cj - 'A']++;
            maxFreq = Math.max(maxFreq, map[cj - 'A']);

            while ((j - i + 1) - maxFreq > k) {
                char ci = s.charAt(i);
                map[ci - 'A']--;
                i++;
            }
            result = Math.max(result, (j - i + 1));
        }
        return result;
    }
}
