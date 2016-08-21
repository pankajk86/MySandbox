package goal.algorithms.strings;

public class ShortestPalindromeString {

    public static void main(String[] args) {
        String s = "abcda";
        String palindrome = getShortestPalindrome(s);
        System.out.println("Palindrome: " + palindrome);
    }

    private static String getShortestPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        StringBuilder sb = new StringBuilder();

        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
            } else {
                sb.append(s.charAt(j));
            }
            j--;
        }

        i = 0;
        j = s.length() - 1;

        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                break;
            }
        }

        return s.substring(0, i) + sb.toString() + s.substring(i, s.length());
    }

}
