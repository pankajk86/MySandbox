package goal.algorithms.strings;

import java.util.HashSet;
import java.util.Set;

public class WordSegment {

    public static void main(String[] args) {

        Set<String> dict = new HashSet<String>();
        dict.add("man");
        dict.add("power");
        dict.add("dental");
        dict.add("mental");
        dict.add("rental");
        dict.add("den");
        dict.add("random");
        String str = "mandentalpower";

        boolean success = segmentWords(dict, str);
        System.out.println("Words can be segmented? " + success);
    }

    private static boolean segmentWords(Set<String> dict, String str) {

        if (dict.contains(str)) {
            return true;
        }

        int end = 1;

        while (end <= str.length()) {
            String part = str.substring(0, end);

            if (dict.contains(part)) {
                boolean success = true;
                if (end < str.length()) {
                    success = segmentWords(dict, str.substring(end));
                }

                if (success) {
                    return true;
                }
            }
            end++;
        }
        return false;
    }

}
