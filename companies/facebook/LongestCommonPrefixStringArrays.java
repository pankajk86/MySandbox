package facebook;

import java.util.Arrays;

public class LongestCommonPrefixStringArrays {

    public static void main(String[] args) {
        String[] sarr = {"flower", "flow", "flight"};
        String result = longestCommonPrefix(sarr);
        System.out.println(result);

        result = longestCommonPrefix2(sarr);
        System.out.println(result);
    }

    /**
     * T:
     *    O(n log n) sorting step, where n is the number of strings in the array.
     *    Comparing s[0], and s[1] takes O(m) time, where m is length of shortest string.
     * S: O(1)
     *
     * @param sarr
     * @return
     */
    private static String longestCommonPrefix(String[] sarr) {
        Arrays.sort(sarr);
        String s1 = sarr[0], s2 = sarr[sarr.length - 1];
        int i = 0;

        while (i < s1.length() && s1.charAt(i) == s2.charAt(i)) {
            i++;
        }

        return s1.substring(0, i);
    }

    /**
     * T : O(n), n = sum of all characters in string list.
     * S : O(1)
     * @param strs
     * @return
     */
    private static String longestCommonPrefix2(String[] strs) {
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}
