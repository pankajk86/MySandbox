package facebook;

public class OptimalPartitioningOfString {

    public static void main(String[] args) {
        String s = "abacaba";
        int result = partition(s);
        System.out.println(result);
    }

    private static int partition(String s) {
        int[] set = new int[26];
        int result = 0;

        for (int i = 0; i < s.length();) {
            char c = s.charAt(i);
            if (set[c - 'a'] == 0) {
                set[c - 'a'] = 1;
                i++;
            } else {
                result++;
                set = new int[26];
            }
        }
        return result + 1;
    }
}
