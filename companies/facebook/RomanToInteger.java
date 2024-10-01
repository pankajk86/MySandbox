package facebook;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        String roman = "MCMXCIVI";
        int result = convert(roman);
        System.out.println(result);

        result = convertII(roman);
        System.out.println(result);
    }


    private static int convert(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            char curr = s.charAt(i), next = s.charAt(i + 1);
            if (map.get(curr) < map.get(next)) result -= map.get(curr);
            else result += map.get(curr);
        }

        result += map.get(s.charAt(s.length() - 1));
        return result;
    }

    private static int convertII(String s) {
        String keys = "IVXLCDM";
        int[] values = {1, 5, 10, 50, 100, 500, 1000};

        int result = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            char curr = s.charAt(i), next = s.charAt(i + 1);
            int currVal = values[keys.indexOf(curr)], nextVal = values[keys.indexOf(next)];

            if (currVal < nextVal) result -= currVal;
            else result += currVal;
        }

        result += values[keys.indexOf(s.charAt(s.length() - 1))];
        return result;
    }

}
