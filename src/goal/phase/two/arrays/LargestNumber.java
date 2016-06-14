package goal.phase.two.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    public static void main(String[] args) {

        int[] a = { 3, 30, 34, 5, 9 };
        String largest = getLargestNumber(a);

        System.out.println("Result: " + largest);
    }

    private static String getLargestNumber(int[] a) {

        String[] s = new String[a.length];

        for (int i = 0; i < a.length; i++) {
            s[i] = String.valueOf(a[i]);
        }

        Arrays.sort(s, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {

                String s1 = o1 + o2;
                String s2 = o2 + o1;

                return -s1.compareTo(s2);
            }

        });

        StringBuilder sb = new StringBuilder();

        for (String ss : s) {
            sb.append(ss);
        }

        if (sb.charAt(0) == '0' && sb.length() > 1) {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }

}
