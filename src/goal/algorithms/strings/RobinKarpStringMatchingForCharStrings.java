package goal.algorithms.strings;

public class RobinKarpStringMatchingForCharStrings {

    public static void main(String[] args) {
        String text = "abcdefgh";
        String pattern = "abcd";

        int startLoc = searchPattern(text, pattern);
        System.out.println("Starting Location of the pattern in text: " + startLoc);
    }

    /*
     * The logic is wrong in here.
     */
    private static int searchPattern(String text, String pattern) {

        int patternHash = 1;
        int n = text.length();
        int m = pattern.length();

        for (int i = 0; i < m; i++) {
            char c = pattern.charAt(i);
            int primeCode = Characters.valueOf(String.valueOf(c)).getPrimeCode();
            patternHash *= primeCode;
        }

        for (int i = 0; i < (n - m + 1); i++) {
            int textPartHash = 1;

            for (int j = i; j < (i + m); j++) {
                char c = text.charAt(j);
                int primeCode = Characters.valueOf(String.valueOf(c)).getPrimeCode();
                textPartHash *= primeCode;
            }

            if (textPartHash == patternHash) {
                return i;
            }
        }

        return -1;
    }
}

enum Characters {

    a(2), b(3), c(5), d(7), e(9), f(11), g(13), h(17), i(19), j(23), k(29), l(31), m(37), n(41), o(43), p(47), q(53), r(
            61), s(67), t(71), u(73), v(79), w(83), x(87), y(93), z(97);

    private final int primeCode;

    Characters(int primeCode) {
        this.primeCode = primeCode;
    }

    public int getPrimeCode() {
        return this.primeCode;
    }
}
