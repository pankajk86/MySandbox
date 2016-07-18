package goal.algorithms.strings;

import java.util.HashSet;
import java.util.Set;

public class WordSegment {

    static String sentence = "";

    public static void main(String[] args) {
        test1();
        sentence = "";
        test2();
    }

    private static void test1() {
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
        System.out.println("(test1): Words can be segmented? " + success);
        System.out.println(sentence);
    }

    private static void test2() {
        Set<String> dict = new HashSet<String>();
        dict.add("from");
        dict.add("waterloo");
        dict.add("hi");
        dict.add("am");
        dict.add("yes");
        dict.add("i");
        dict.add("am");
        dict.add("a");
        dict.add("student");
        String str = "iamastudentfromwaterloo";

        boolean success = segmentWords(dict, str);
        System.out.println("(test2): Words can be segmented? " + success);
        System.out.println(sentence);
    }

    private static boolean segmentWords(Set<String> dict, String str) {

        if (dict.contains(str)) {
            sentence = str + " " + sentence;
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
                    sentence = part + " " + sentence;
                    return true;
                }
            }
            end++;
        }
        return false;
    }

}
