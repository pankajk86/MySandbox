package facebook;

public class ValidPalindrome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean result = isPalindrome(s);
    }

    private static boolean isPalindrome(String s) {
        s = s.toLowerCase();

        for (int i = 0, j = s.length() - 1; i <= j;) {
            char ci = s.charAt(i), cj = s.charAt(j);
            if (isValid(ci) && isValid(cj)) {
                if (ci == cj) {
                    i++; j--;
                }
                else return false;
            } else {
                if (!isValid(ci)) i++;
                else j--;
            }
        }
        return true;
    }

    private static boolean isValid(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}
