package facebook;

public class CheckIfTwoStringArraysAreEquivalent {

    public static void main(String[] args) {
        String[] word1 = {"ab", "c"}, word2 = {"a", "bc"};
        boolean result = areEquivalent(word1, word2);
        System.out.println(result);

        result = areEquivalentSimpler(word1, word2);
        System.out.println(result);
    }

    private static boolean areEquivalentSimpler(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
        for (String s : word1) sb1.append(s);
        for (String s : word2) sb2.append(s);
        return sb1.toString().contentEquals(sb2);
    }

    private static boolean areEquivalent(String[] word1, String[] word2) {
        int i = 0, j = 0, ii = 0, jj = 0;

        while (i < word1.length && j < word2.length) {
            String s1 = word1[i], s2= word2[j];

            while (ii < s1.length() && jj < s2.length()) {
                if (s1.charAt(ii) != s2.charAt(jj)) return false;
                ii++;
                jj++;
            }
            if (ii == s1.length()) {
                i++; ii = 0;
            }
            if (jj == s2.length()) {
                j++; jj = 0;
            }
        }

        return i == word1.length && j == word2.length;
    }
}
