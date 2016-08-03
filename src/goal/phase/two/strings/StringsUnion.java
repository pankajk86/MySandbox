package goal.phase.two.strings;

import java.util.HashSet;
import java.util.Set;

public class StringsUnion {

    public static void main(String[] args) {
        String a = "abc", b = "bcde";
        String union = getSubstractUnion(a, b);
        System.out.println(union);
    }

    private static String getSubstractUnion(String a, String b) {

        Set<Character> setA = new HashSet<>();
        Set<Character> setB = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (char c : a.toCharArray()) {
            setA.add(c);
        }

        for (char c : b.toCharArray()) {
            setB.add(c);
        }

        Set<Character> tempA = new HashSet<>(setA);

        setA.removeAll(setB);
        setB.removeAll(tempA);

        for (char c : setA) {
            sb.append(c);
        }

        for (char c : setB) {
            sb.append(c);
        }

        return sb.toString();
    }

}
