package goal.phase.two.arrays;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordLadder {

    private static List<String> ladder = new LinkedList<String>();

    public static void main(String[] args) {

        String start = "hit", end = "cog";
        Set<String> dict = new HashSet<String>();
        dict.add("hot");
        dict.add("dot");
        dict.add("lot");
        dict.add("dog");
        dict.add("log");

        countWordLadder(start, end, dict);

        for (String s : ladder) {
            System.out.print(s + " ");
        }

        System.out.println("\nResult: " + ladder.size());
    }

    private static void countWordLadder(String start, String end, Set<String> dict) {

        List<String> q = new LinkedList<String>();

        ladder.add(start);

        q.add(start);
        dict.add(end);

        while (!q.isEmpty()) {
            String s = q.remove(0);
            String next = findNext(s, end, dict);
            ladder.add(next);

            if (next.equals(end)) {
                return;
            }

            q.add(next);
        }

        return;
    }

    private static String findNext(String str, String end, Set<String> dict) {

        String next = null;

        for (String s : dict) { // hot, dot, dog, lot, log
            char[] strArr = str.toCharArray(); // hit
            char[] sArr = s.toCharArray();
            int diff = 0;

            for (int i = 0; i < sArr.length; i++) {
                if (sArr[i] != strArr[i]) {
                    diff++;
                }

                if (diff > 1) {
                    break;
                }
            }

            if (diff == 1) {
                next = s;

                if (next.equals(end)) {
                    return next;
                }
            }
        }

        return next;
    }

}
