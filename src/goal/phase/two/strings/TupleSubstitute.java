package goal.phase.two.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TupleSubstitute {

    static List<List<Character>> tupleList = new ArrayList<>();

    public static void main(String[] args) {
        List<Character> list = new ArrayList<>();
        list.addAll(Arrays.asList('a', 'b', 'c'));
        char[] c = new char[3]; // number of arguments

        getTupleList(list, c, 0);
        
        System.out.println(tupleList.toString());
    }

    private static void getTupleList(List<Character> list, char[] carr, int i) {
        if (i == list.size()) {
            List<Character> t = new ArrayList<>();
            for (char c : carr) {
                t.add(c);
            }
            tupleList.add(t);
        } else {
            carr[i] = '*';
            getTupleList(list, carr, i + 1);
            carr[i] = list.get(i);
            getTupleList(list, carr, i + 1);
        }
    }

}
