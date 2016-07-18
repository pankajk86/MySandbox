package goal.phase.two.strings;

public class CheckEditDistanceOne {

    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "abcdf";

        boolean result = isEditDistanceOne(s1, s2);
        System.out.println("Result: " + result);
    }

    private static boolean isEditDistanceOne(String s1, String s2) {

        int m = s1.length(), n = s2.length();

        if (Math.abs(m - n) > 1) {
            return false;
        }

        int count = 0, i = 0, j = 0;

        while (i < m && j < n) {
            if (s1.charAt(i) != s2.charAt(j)) {
                if (count == 1) {
                    return false;
                }

                if (m > n) {
                    i++;
                } else if (m < n) {
                    j++;
                } else {
                    i++;
                    j++;
                }
                count++;
            } else {
                i++;
                j++;
            }
        }

        if (i < m || j < n) {
            count++;
        }

        return count == 1;
    }

}
