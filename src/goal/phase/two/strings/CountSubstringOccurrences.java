package goal.phase.two.strings;

public class CountSubstringOccurrences {

    public static void main(String[] args) {
        String s = "abcdefhcdghcdelejleljgcdelaf'lldkf";
        String t = "cde";

        int occurrences = getOccurrences(s, t);
        System.out.println("# of occurrences: " + occurrences);
    }

    private static int getOccurrences(String s, String t) {

        int j = 0, occurrence = 0;

        for (int i = 0; i < s.length(); i++) {
            if (j == t.length()) {
                occurrence++;
                j = 0;
            } else if (s.charAt(i) == t.charAt(j)) {
                j++;
            }
        }

        return j == t.length() ? occurrence + 1 : occurrence;
    }

}
