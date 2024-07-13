package facebook;

import java.util.Stack;

public class SimplifyPath {

    public static void main(String[] args) {
        String s = "/.../a/../b/c/../d/./";
        String result = simplify(s);
        System.out.println(result);
    }

    private static String simplify(String path) {
        String[] parts = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String s : parts) {
            if (s.isEmpty() || s.equals(".")) continue;
            else if (s.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            }
            else stack.push(s);
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.insert(0, "/" + stack.pop());
        }

        return sb.toString().isEmpty() ? "/" : sb.toString();
    }
}
