package linkedin;

import java.util.*;

public class ShuffleString {

    public static void main(String args[]) {
        String s = "apple";
        String result = shuffle(s);
        System.out.println(result);
    }

    // 1, 2, 3, 4, 5, 6, 7

    private static String shuffle(String s) {
        Random rand = new Random();
        List<Character> list = new ArrayList<>();
        for (char c : s.toCharArray()) list.add(c);

        StringBuilder sb = new StringBuilder();
        while (!list.isEmpty()) {
            int index = rand.nextInt(list.size());
            sb.append(list.remove(index));
        }

        return sb.toString();

    }
}
