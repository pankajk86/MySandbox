package facebook;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class SimplifyPath {

    public static void main(String[] args) {
        String s = "/.../a/../b/c/../d/./";
        String result = simplifyWithStack(s);
        System.out.println(result);

        result = simplifyWithDeque(s);
        System.out.println(result);
    }

    private static String simplifyWithDeque(String path) {
        String[] parts = path.split("/");
        Deque<String> dq = new ArrayDeque<>();

        for (String part : parts) {
            if (part.isEmpty() || part.equals(".")) continue;
            if (part.equals("..")) {
                if (!dq.isEmpty()) dq.removeLast();
            } else dq.addLast(part);
        }

        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            sb.append("/").append(dq.removeFirst());
        }

        return sb.isEmpty() ? "/" : sb.toString();
    }

    private static String simplifyWithStack(String path) {
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
