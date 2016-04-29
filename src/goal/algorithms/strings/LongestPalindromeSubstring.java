package goal.algorithms.strings;

public class LongestPalindromeSubstring {

    public static void main(String[] args) {

        String str = "abcdedcbag";
        System.out.println("Longest Palindrome: " + getLongestPalindrome(str));
    }

    private static String getLongestPalindrome(String str) {

        if (str.isEmpty()) {
            return null;
        }

        if (str.length() == 1) {
            return str;
        }

        String longest = str.substring(0, 1);

        for (int i = 0; i < str.length(); i++) {

            /*
             * this is one is check the longest palindrome with just i as the
             * center this is for strings with single central character, like:
             * "abcba".
             */
            String temp = getLongestPalindrome(str, i, i);
            if (temp.length() > longest.length()) {
                longest = temp;
            }

            /*
             * this is one is check the longest palindrome with just i and i+1
             * as the center this is for strings with two central character,
             * like: "abccba".
             */
            temp = getLongestPalindrome(str, i, i + 1);
            if (temp.length() > longest.length()) {
                longest = temp;
            }
        }

        return longest;
    }

    /**
     * This method returns the longest palindrome with the given center
     * position. The center position, begin and end, keeps on moving towards the
     * beginning and the end respectively, if the condition is satisfied.
     * 
     * @param str
     * @param begin
     * @param end
     * @return
     */
    private static String getLongestPalindrome(String str, int begin, int end) {

        while (begin >= 0 && end <= str.length() - 1 && str.charAt(begin) == str.charAt(end)) {
            begin--;
            end++;
        }

        return str.substring(begin + 1, end);
    }

}
