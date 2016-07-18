package goal.phase.two.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfPhoneNumber {

    public static void main(String[] args) {
        String numString = "234";
        List<String> combinations = getLetterCombinations(numString);

        for (String s : combinations) {
            System.out.println(s);
        }
    }

    private static List<String> getLetterCombinations(String numString) {
        Map<Character, char[]> map = new HashMap<>();
        map.put('2', new char[] { 'a', 'b', 'c' });
        map.put('3', new char[] { 'd', 'e', 'f' });
        map.put('4', new char[] { 'g', 'h', 'i' });
        map.put('5', new char[] { 'j', 'k', 'l' });
        map.put('6', new char[] { 'm', 'n', 'o' });
        map.put('7', new char[] { 'p', 'q', 'r', 's' });
        map.put('8', new char[] { 't', 'u', 'v' });
        map.put('9', new char[] { 'w', 'x', 'y', 'z' });

        List<String> result = new ArrayList<>();

        helper(result, new StringBuilder(), numString, 0, map);
        return result;
    }

    private static void helper(List<String> result, StringBuilder sb, String digits, int index,
            Map<Character, char[]> map) {

        if (index >= digits.length()) {
            result.add(sb.toString());
            return;
        }

        char c = digits.charAt(index);
        char[] chars = map.get(c);

        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i]);
            helper(result, sb, digits, index + 1, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
