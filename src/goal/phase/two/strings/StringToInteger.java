package goal.phase.two.strings;

public class StringToInteger {

    public static void main(String[] args) {

        String s = "123456 ";
        int a = atoi(s);
        System.out.println("Integer value: " + (a + 1));
    }

    private static int atoi(String s) {

        double result = 0;
        int type = 1;
        int i = 0;

        if (s.charAt(0) == '-') {
            type = -1;
            i++;
        } else if (s.charAt(0) == '+') {
            i++;
        }

        s = s.trim();

        while (i < s.length()) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                result = result * 10 + Character.getNumericValue(c);
            }
            i++;
        }

        result = result * type;

        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) result;
    }

}
