package goal.algorithms.strings;

public class WildCardPatternMatching {

    public static void main(String[] args) {
        String str = "abcdefghi";
        String pattern = "a???e*?";

        boolean result = matchWildcardPattern(str, pattern);
        System.out.println("Result: " + result);
    }

    private static boolean matchWildcardPattern(String str, String pattern) {

        int strLen = str.length();
        int pattLen = pattern.length();

        if (strLen < pattLen) {
            return false;
        } else if (strLen == pattLen) {
            for (int i = 0, j = 0; i < strLen; i++, j++) {
                if (str.charAt(i) == pattern.charAt(j)) {
                    continue;
                } else if (pattern.charAt(j) == '?' || pattern.charAt(j) == '*') {
                    continue;
                } else {
                    return false;
                }
            }
            return true;
        } else {

            int i = 0, j = 0;

            while (j < pattLen) {
                if (str.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '?') {
                    i++;
                    j++;
                    continue;
                } else if (pattern.charAt(j) == '*') {

                    if (j == pattLen - 1) {
                        return true;
                    }

                    char nextInPattern = pattern.charAt(++j);

                    if (nextInPattern == '*' || nextInPattern == '?') {
                        while (pattern.charAt(j) != '*' || pattern.charAt(j) != '?') {
                            if (j == pattLen - 1) {
                                return true;
                            }
                            j++;
                        }
                    }

                    while (i < (strLen - 1) && str.charAt(i) != nextInPattern) {
                        i++;
                    }

                    if (i == strLen - 1) {
                        return false;
                    }
                } else {
                    return false;
                }
            }

            if (i < strLen) {
                return false;
            } else {
                return true;
            }
        }
    }

}
