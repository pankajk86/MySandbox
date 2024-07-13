package facebook;

public class CustomSortString {

    public static void main(String[] args) {
        String order = "cba", s = "abcd";
        String result = customSort(order, s);
        System.out.println(result);
    }

    private static String customSort(String order, String s) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) map[c - 'a']++;

        StringBuilder sb = new StringBuilder();

        for (char c : order.toCharArray()) {
            if (map[c - 'a'] > 0) {
                for (int i = 0; i < map[c - 'a']; i++) sb.append(c);
                map[c - 'a'] = 0;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (map[i] > 0) {
                for (int j = 0; j < map[i]; j++) sb.append((char)(i + 'a'));
            }
        }

        return sb.toString();
    }
}
