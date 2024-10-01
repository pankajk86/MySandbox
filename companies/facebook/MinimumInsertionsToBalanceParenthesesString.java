package facebook;

public class MinimumInsertionsToBalanceParenthesesString {

    public static void main(String[] args) {
        String s = "(()))";
        int result = balanceString(s);
        System.out.println(result);
    }

    private static int balanceString(String s) {
        int left = 0, right = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (right % 2 > 0) {
                    right--;
                    left++;
                }
                right += 2;
            } else {
                if (right == 0) {
                    right += 2;
                    left++;
                }
                right--;
            }
        }

        return left + right;
    }
}
