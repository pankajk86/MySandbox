package goal.phase.two.strings;

public class LongestCommonPrefix {

    public static void main(String[] args) {

        String[] a = { "abcd efg", "abc defg", "abcd efghi", "abcdefg" };
        String prefix = getLongestCommonPrefix(a);

        System.out.println("Result: " + prefix);
    }

    private static String getLongestCommonPrefix(String[] str) {

        String shortest = null;
        int shortestCount = Integer.MAX_VALUE;

        for (String s : str) {
            if (s.length() < shortestCount) {
                shortestCount = s.length();
                shortest = s;
            }
        }

        for (int i = 0; i < shortestCount; i++) {
            for (int j = 0; j < str.length - 1; j++) {
                String s1 = str[j];
                String s2 = str[j + 1];

                if (s1.charAt(i) != s2.charAt(i)) {
                    return s1.substring(0, i);
                }
            }
        }

        return shortest;
    }

}
