package facebook;

public class NumberOfWonderfulSubstrings {

    public static void main(String[] args) {
        String s = "aabb";
        long result = wonderfulSubstrings(s);
        System.out.println(result);
    }

    private static long wonderfulSubstrings(String s) {
        long[] map = new long[1024];
        int xor = 0;
        map[0] = 1;
        long result = 0;

        for (char c : s.toCharArray()) {
            xor ^= (1 << (c - 'a'));
            result += map[xor];
            map[xor]++;

            for (int i = 0; i < 10; i++) {
                int checkXor = xor ^ (1 << i);
                result += map[checkXor];
            }
        }
        return result;
    }
}
