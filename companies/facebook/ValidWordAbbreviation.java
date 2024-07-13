package facebook;

public class ValidWordAbbreviation {
    public static void main(String[] args) {
        String word = "internationalization", abbr = "i12iz4n";
        boolean result = validWordAbbreviation(word, abbr);
        System.out.println(result);
    }

    private static boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            char c1 = word.charAt(i), c2 = abbr.charAt(j);
            if (c1 == c2) {
                i++; j++; continue;
            }

            if (c2 <= '0' || c2 > '9') return false;

            int start = j;
            while (j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                j++;
            }
            i += Integer.parseInt(abbr.substring(start, j));
        }
        return i == word.length() && j == abbr.length();
    }
}
