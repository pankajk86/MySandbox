package goal.algorithms.recursion;

import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {

        int n = 3;
        List<String> result = new LinkedList<String>();
        dfs(result, "", n, n);

        for (String str : result) {
            System.out.println(str);
        }
    }

    private static void dfs(List<String> result, String string, int left, int right) {

        if (left > right) {
            return;
        }

        if (left == 0 && right == 0) {
            result.add(string);
            return;
        }

        if (left > 0) {
            dfs(result, string + "(", left - 1, right);
        }

        if (right > 0) {
            dfs(result, string + ")", left, right - 1);
        }
    }

}
