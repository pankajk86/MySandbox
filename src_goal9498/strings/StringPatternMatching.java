package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringPatternMatching {

    public static void main(String[] args) {
        String pattern = "abbca";
        String[] dictionary = { "cdfd", "tooft", "hfgdt", "paa" };
        System.out.println(findMatch(dictionary, pattern));
    }

    private static List<String> findMatch(String[] dictionary, String pattern) {

        List<String> list = new ArrayList<>();
        String encodePattern = encode(pattern);

        for (String s : dictionary) {
            if (encode(s).equals(encodePattern)) {
                list.add(s);
            }
        }

        return list;
    }

    private static String encode(String pattern) {

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (char c : pattern.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, ++count);
            }
            sb.append(map.get(c));
        }
        return sb.toString();
    }

}
