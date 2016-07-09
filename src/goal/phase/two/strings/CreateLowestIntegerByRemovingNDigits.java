package goal.phase.two.strings;

public class CreateLowestIntegerByRemovingNDigits {

    public static void main(String[] args) {

        String s = "372180765294";
        int n = 7;
        String result = buildLowestNumber(s, n);
        System.out.println("Result: " + result);
    }

    private static String buildLowestNumber(String s, int n) {

        String result = "";

        if (n == 0) {
            result += s;
            return result;
        }

        int length = s.length();

        if (length <= n) {
            return null;
        }

        int minIndex = 0;

        for (int i = 1; i <= n; i++) {
            if (s.charAt(i) < s.charAt(minIndex)) {
                minIndex = i;
            }
        }

        String newS = s.substring(minIndex + 1, length);
        result += s.charAt(minIndex) + buildLowestNumber(newS, n - minIndex);
        return result;
    }

}
