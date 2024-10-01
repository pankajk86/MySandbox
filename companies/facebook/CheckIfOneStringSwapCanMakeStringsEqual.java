package facebook;

public class CheckIfOneStringSwapCanMakeStringsEqual {

    public static void main(String[] args) {
        String s1 = "bank", s2 = "kanb";
        boolean result = canBeEqual(s1, s2);
        System.out.println(result);
    }

    private static boolean canBeEqual(String s1, String s2) {
        if (s1.equals(s2)) return true;

        int[] map1 = new int[26], map2 = new int[26];
        int count = 0;

        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i), c2 = s2.charAt(i);
            if (c1 != c2) count++;
            if (count > 2) return false;

            map1[c1 - 'a']++;
            map2[c2 - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (map1[i] != map2[i]) return false;
        }

        return true;
    }
}
