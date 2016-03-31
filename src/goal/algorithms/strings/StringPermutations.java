package goal.algorithms.strings;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {

    static List<String> permutedStringsList = new ArrayList<String>();

    public static void main(String[] args) {
        String str = "abcd";
        stringPermutations("", str);

        for (String s : permutedStringsList) {
            System.out.println(s);
        }
    }

    private static void stringPermutations(String prefix, String str) {
        int n = str.length();

        if (n == 0) {
            permutedStringsList.add(prefix);
        }

        for (int i = 0; i < n; i++) {
            // we are keeping one character fix (char at index i) and then
            // calculating permutations of others
            stringPermutations(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
        }
    }

}
