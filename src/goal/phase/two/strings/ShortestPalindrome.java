package goal.phase.two.strings;


public class ShortestPalindrome {

    public static void main(String[] args) {

        String a = "abcd";
        String palindrome = getPalindrome(a);

        System.out.println("Result: " + palindrome);
    }

    private static String getPalindrome(String s) {

        String palindrome = null;

        for (int i = s.length() - 1; i >= 0; i--) {

            palindrome = palindrome(s, i);

            if (palindrome != null) {
                return palindrome;
            }
        }

        return palindrome;
    }

    private static String palindrome(String s, int idx) {

        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(idx)).reverse();

        String str = sb.append(s).toString();

        for (int i = 0, j = str.length() - 1; i <= j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return null;
            }
        }

        return str;
    }

}
