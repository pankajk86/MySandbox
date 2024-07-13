package facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {

    public static void main(String[] args) {
        String[] arr = {"zab", "abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        List<List<String>> result = groupStrings(arr);
        System.out.println(result);
    }

    private static List<List<String>> groupStrings(String[] arr) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : arr) {
            String index = getIndex(s);
            List<String> list = map.getOrDefault(index, new ArrayList<>());
            list.add(s);
            map.put(index, list);
        }

        return new ArrayList<>(map.values());
    }

    private static String getIndex(String s) {
        int offset = s.charAt(0) - 'a';
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            char curr = (char)(c - offset);
            if (curr < 'a') curr += 26;
            sb.append(curr);
        }
        return sb.toString();
    }
}
