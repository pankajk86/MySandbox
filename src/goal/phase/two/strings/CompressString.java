package goal.phase.two.strings;

public class CompressString {

    public static void main(String[] args) {

        String s = "aabcccccaaab";
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;

        for (j = 1; j < s.length(); j++) {
            if (s.charAt(j) != s.charAt(j - 1)) {
                sb.append(s.charAt(i)).append(j - i);
                i = j;
            }
        }

        if (i < j) {
            sb.append(s.charAt(i)).append(j - i);
        }

        String compressed = sb.toString();

        if (compressed.length() == s.length()) {
            System.out.println(s);
        } else {
            System.out.println(compressed);
        }
    }

}
