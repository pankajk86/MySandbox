package facebook;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInStringII {

    public static void main(String[] args) {
        String s = "deeedbbcccbdaa";
        int k = 3;

        String result = removeDuplicates(s, k);
        System.out.println(result);
    }

    private static String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || stack.peek().c != c)
                stack.push(new Pair(c, 1));
            else {
                Pair curr = stack.pop();
                if (curr.freq < k - 1)
                    stack.push(new Pair(c, curr.freq + 1));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Pair p : stack) {
            for (int i = 0; i < p.freq; i++) {sb.append(p.c);}
//            sb.repeat(p.c, p.freq);
        }

        return sb.toString();
    }
}

class Pair {
    char c;
    int freq;

    public Pair(char c, int freq) {
        this.c = c;
        this.freq = freq;
    }
}
