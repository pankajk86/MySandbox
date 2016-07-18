package goal.phase.two.strings;

public class SecondHighestFrequencyCharacter {

    public static void main(String[] args) {
        String s = "aaabbccccc";
        char c = getSecondHighestFrequent(s);
        System.out.println("Result: " + c);
    }

    private static char getSecondHighestFrequent(String s) {

        int i = 1, j = 0;
        StringBuilder sb = new StringBuilder();

        while (i < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                sb.append(s.charAt(j)).append(i - j);
                j = i;
            }
            i++;
        }

        sb.append(s.charAt(j)).append(i - j);

        String compressed = sb.toString();
        char c1 = '\0', c2 = '\0';
        int l1 = 0, l2 = 0;

        for (i = 1; i < compressed.length(); i = i + 2) {
            int n = Integer.parseInt(String.valueOf(compressed.charAt(i)));

            if (n > l1 && n > l2) {
                l2 = l1;
                l1 = n;
                c2 = c1;
                c1 = compressed.charAt(i - 1);
            } else if (n > l2 && n < l1) {
                l2 = n;
                c2 = compressed.charAt(i - 1);
            }
        }

        return c2;
    }

}
