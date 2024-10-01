package facebook;

public class MergeStringAlternatively {

    public static void main(String[] args) {
        String word1 = "abc", word2 = "pqr";
        String result = merge(word1, word2);
        System.out.println(result);
    }

    private static String merge(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        int i = 0, j = 0;

        while (i < s1.length() && j < s2.length()) {
            if (flag) sb.append(s1.charAt(i++));
            else sb.append(s2.charAt(j++));
            flag = !flag;
        }

        while(i < s1.length()) sb.append(s1.charAt(i++));
        while(j < s2.length()) sb.append(s2.charAt(j++));
        return sb.toString();
    }
}
