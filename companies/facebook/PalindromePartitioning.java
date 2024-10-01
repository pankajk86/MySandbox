package facebook;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> result = partition(s);
        System.out.println(result);
    }

    /**
     * T: O(n.2^n)
     * S: O(n.2^n)
     * @param s
     * @return
     */
    private static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        dfs(s, result, new ArrayList<>(), 0);
        return result;
    }

    private static void dfs(String s, List<List<String>> result, List<String> temp, int i) {
        if (i >= s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(s, i, j)) {
                temp.add(s.substring(i, j + 1));
                dfs(s, result, temp, j + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++; j--;
            } else return false;
        }
        return true;
    }
}
